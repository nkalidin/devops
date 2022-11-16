provider "azurerm" {
  features {}
}

locals {
  hexa-env  = "hexa-dev"
  hexa-name = "hexa-server"
}

resource "azurerm_resource_group" "hexa-rg1" {
  location = "eastus"
  name     = "${local.hexa-env}-resourcegroup1"
}

resource "azurerm_resource_group" "hexa-rg2" {
  location = "eastus"
  name     = "${local.hexa-env}-resourcegroup2"
}

resource "azurerm_resource_group" "hexa-rg3" {
  location = "eastus"
  name     = "${local.hexa-env}-resourcegroup3"
}

resource "azurerm_virtual_network" "hexa-day2-net2" {
  resource_group_name = azurerm_resource_group.hexa-rg1.name
  address_space       = ["43.33.0.0/24"]
  location            = "eastus"
  name                = "${local.hexa-env}"
}


