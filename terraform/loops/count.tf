provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "hexa-rg" {
  count    = length(var.rg)
  location = "eastus"
  name     = var.rg[count.index]
}

variable "rg" {
  type    = list(string)
  default = ["hexa1", "hexa2", "hexa3"]
}


resource "azurerm_resource_group" "hexagon-rg" {
  count    = length(var.hexa1)
  location = "southindia"
  name     = var.hexa1[count.index]

}

variable "hexa1" {
  type    = list(string)
  default = ["h1", "h2", "h3", "h4"]

}

resource "azurerm_resource_group" "hexagon-rg2" {
  count    = var.test1
  location = "southindia"
  name     = "samosa-${count.index}"

}

variable "test1" {
  type    = number
  default = 4
}
