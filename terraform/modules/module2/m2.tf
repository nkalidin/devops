provider "azurerm" {
  features {}
}

locals {
  rg_tag = "${terraform.workspace}-module2"
}
resource "azurerm_resource_group" "hexa-day5-rg2" {
  name     = "hexa-day5-rg2"
  location = "eastus"
  tags = {
    Name = local.rg_tag
      }
}
