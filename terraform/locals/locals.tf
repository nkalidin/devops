provider "azurerm" {
    features {}
}

resource "azurerm_resource_group" "hexa-day2" {
    location = "westus2"
    name = "hexa-day2-resourcegroup" 
}


resource "azurerm_virtual_network" "hexa-day2-net1" {
  resource_group_name                = "hexa-day2-net1"
  address_space       = ["33.33.0.0/24"]
  location            = "eastus"
  
}

resource "azurerm_subnet" "hexa-day2-net1-s1" {
  name                 = "hexa-day2-net1-s1"
  resource_group_name  = azurerm_resource_group.hexa-day2.name
  virtual_network_name = azurerm_virtual_network.hexa-day2-net1.name
  address_prefixes     = [var.subnet1_cidr]
}


resource "azurerm_network_interface" "hexa-day2-nic1" {
  name                = "hexa-day2-nic1"
  location            = azurerm_resource_group.hexa-day2.location
  resource_group_name = azurerm_resource_group.hexa-day2.name

  ip_configuration {
    name                          = "hexa-day2-net1-s1"
    subnet_id                     = azurerm_subnet.hexa-day2-net1-s1.id
    private_ip_address_allocation = "Dynamic"
  }
}
