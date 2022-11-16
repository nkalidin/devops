terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.31.0"
    }
  }
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "vadapav" {
  name     = "vadapav"
  location = "east us"
  tags = {
    "name" = "vadapav1"
    "env"  = "prod"
  }
}

resource "azurerm_virtual_network" "hexagon-net1" {
  name                = "hexagon-net1"
  address_space       = ["90.0.0.0/24"]
  location            = azurerm_resource_group.vadapav.location
  resource_group_name = azurerm_resource_group.vadapav.name
}

resource "azurerm_subnet" "hexagon-net1-s1" {
  name                 = "hexagon-net1-s1"
  resource_group_name  = azurerm_resource_group.vadapav.name
  virtual_network_name = azurerm_virtual_network.hexagon-net1.name
  address_prefixes     = ["90.0.0.0/25"]
}

resource "azurerm_network_interface" "hexagon-nic1" {
  name                = "hexagon-nic1"
  location            = azurerm_resource_group.vadapav.location
  resource_group_name = azurerm_resource_group.vadapav.name

  ip_configuration {
    name                          = "hexagon-net1-s1"
    subnet_id                     = azurerm_subnet.hexagon-net1-s1.id
    private_ip_address_allocation = "Dynamic"
  }
}
resource "azurerm_linux_virtual_machine" "vm1" {
  name                            = "vm1"
  location                        = azurerm_resource_group.vadapav.location
  resource_group_name             = azurerm_resource_group.vadapav.name
  admin_username                  = "hexagon"
  admin_password                  = "Hexagon@123"
  size                            = "Standard_B1ms"
  disable_password_authentication = false

  os_disk {
    storage_account_type = "Standard_LRS"
    caching              = "ReadWrite"
  }
  source_image_reference {
    publisher = "Canonical"
    offer     = "UbuntuServer"
    sku       = "16.04-LTS"
    version   = "latest"
  }
  network_interface_ids = [
  azurerm_network_interface.hexagon-nic1.id]

  custom_data = filebase64("docker1.tmpl")

}
