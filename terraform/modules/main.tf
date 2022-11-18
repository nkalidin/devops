provider "azurerm" {
  features {}
}

module "w1" {
  source = ".//module1"
}

resource "azurerm_virtual_network" "hexa-day5-net1" {
  resource_group_name = "hexa-day5-rg1"
  address_space       = ["43.37.0.0/24"]
  location            = "centralindia"
  name                = "hexa-day5-net1"
  depends_on = [
    module.w1
 ]
}

module "w2" {
  source = ".//module2"
}
resource "azurerm_virtual_network" "hexa-day5-net2" {
  resource_group_name = "hexa-Day5-rg2"
  address_space       = ["43.37.0.0/24"]
  location            = "eastus"
  name                = "hexa-day5-net2"
  depends_on = [
    module.w2
 ]
}
