provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "hexa-rg33" {
  location = "eastus"
  name     = "hexa-rg33"
}

resource "azurerm_kubernetes_cluster" "k8s" {
  name                = "k8s"
  location            = azurerm_resource_group.hexa-rg33.location
  resource_group_name = azurerm_resource_group.hexa-rg33.name
  dns_prefix          = "hexa"

  default_node_pool {
    name       = "default"
    node_count = "2"
    vm_size    = "standard_d2_v2"
  }
  identity {
    type = "SystemAssigned"
  }
}
