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
  subscription_id = var.subscriptionid
  tenant_id       = var.tenantid
  client_id       = var.clientid
  client_secret   = var.clientsecret
}
resource "azurerm_resource_group" "k8snov" {
  name     = "k8snov"
  location = "eastus"
  tags = {
    "name" = "k8snov"
    "env"  = "production"
  }
}
resource "azurerm_virtual_network" "k8snov_net1" {
  name                = "k8snov-net1"
  address_space       = [var.vnet_cidr]
  location            = azurerm_resource_group.k8snov.location
  resource_group_name = azurerm_resource_group.k8snov.name
}
resource "azurerm_subnet" "k8snov_subnet_01" {
  name                 = "k8snov-subnet-01"
  resource_group_name  = azurerm_resource_group.k8snov.name
  virtual_network_name = azurerm_virtual_network.k8snov_net1.name
  address_prefixes     = [var.subnet_cidr]
}
resource "azurerm_network_interface" "k8s_nic" {
  count               = 3
  name                = "k8s-nic-${count.index}"
  location            = azurerm_resource_group.k8snov.location
  resource_group_name = azurerm_resource_group.k8snov.name
  ip_configuration {
    name                          = "k8snov-nic-ip-${count.index}"
    subnet_id                     = azurerm_subnet.k8snov_subnet_01.id
    private_ip_address_allocation = "Dynamic"
  }
}
resource "azurerm_linux_virtual_machine" "k8snov_ubuntu" {
  count                           = 3
  name                            = "k8snov-ubuntu-${count.index}"
  location                        = azurerm_resource_group.k8snov.location
  resource_group_name             = azurerm_resource_group.k8snov.name
  disable_password_authentication = false
  admin_username                  = "hexagon"
  admin_password                  = "Hexagon@123"
  size                            = "Standard_B2ms"
  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
  }
  source_image_reference {
    publisher = "Canonical"
    offer     = "UbuntuServer"
    sku       = "16.04-LTS"
    version   = "latest"
  }
  network_interface_ids = [azurerm_network_interface.k8s_nic[count.index].id]
}
