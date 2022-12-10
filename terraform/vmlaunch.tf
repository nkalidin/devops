terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.35.0"
    }
  }
}

provider "azurerm" {
  features {}
}
resource "azurerm_resource_group" "vadapav" {
  name     = "vadapav"
  location = "eastus"
  tags = {
    "env" = "prod1"
    "app" = "iifl"
  }
}

resource "azurerm_virtual_network" "vadapav-net1" {

  name                = "vadapav-net1"
  resource_group_name = azurerm_resource_group.vadapav.name
  location            = azurerm_resource_group.vadapav.location
  address_space       = ["99.99.0.0/24"]
}

resource "azurerm_subnet" "vadapav-s1" {
  name                = "vadapav-s1"
  resource_group_name = azurerm_resource_group.vadapav.name
  # location             = azurerm_resource_group.vadapav.location
  address_prefixes     = ["99.99.0.0/25"]
  virtual_network_name = azurerm_virtual_network.vadapav-net1.name

}
resource "azurerm_subnet" "vadapav-s2" {
  name                = "vadapav-s2"
  resource_group_name = azurerm_resource_group.vadapav.name
  # location            = azurerm_resource_group.vadapav.location
  address_prefixes     = ["99.99.0.128/25"]
  virtual_network_name = azurerm_virtual_network.vadapav-net1.name
}

resource "azurerm_public_ip" "vadapav-pip" {

  name                = "vadapav-public-ip"
  location            = azurerm_resource_group.vadapav.location
  resource_group_name = azurerm_resource_group.vadapav.name
  allocation_method   = "Dynamic"

}

resource "azurerm_network_interface" "vm-nic" {
  name                = "vm-nic"
  resource_group_name = azurerm_resource_group.vadapav.name
  location            = azurerm_resource_group.vadapav.location
  ip_configuration {
    name                          = "internal"
    subnet_id                     = azurerm_subnet.vadapav-s1.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.vadapav-pip.id

  }

}
resource "azurerm_linux_virtual_machine" "vm1" {
  name                            = "vm1"
  resource_group_name             = azurerm_resource_group.vadapav.name
  location                        = azurerm_resource_group.vadapav.location
  size                            = "Standard_D2s_v3"
  admin_username                  = "iifl"
  admin_password                  = "Aws@12345678"
  disable_password_authentication = false
  network_interface_ids = [
    azurerm_network_interface.vm-nic.id
  ]
  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
  }
  source_image_reference {
    publisher = "Canonical"
    offer     = "UbuntuServer"
    sku       = "18.04-LTS"
    version   = "latest"
  }
}
