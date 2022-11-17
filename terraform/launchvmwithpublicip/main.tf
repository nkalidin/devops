resource "azurerm_resource_group" "vadapav-rg" {

  name     = "vadapav-rg"

  location = "east us"

  tags = {

    "env"  = "prod"

    "type" = "snacks"

  }

}

 

resource "azurerm_virtual_network" "vadapav-vnet" {

  name                = "vadapav-network"

  address_space       = ["30.30.0.0/16"]

  location            = azurerm_resource_group.vadapav-rg.location

  resource_group_name = azurerm_resource_group.vadapav-rg.name

}

 

resource "azurerm_subnet" "vadapav-sub" {

  name                 = "vadapav-sub"

  resource_group_name  = azurerm_resource_group.vadapav-rg.name

  virtual_network_name = azurerm_virtual_network.vadapav-vnet.name

  address_prefixes     = ["30.30.10.0/24"]

}

 

resource "azurerm_public_ip" "vadapav-pip" {

  count               = var.node_count

  name                = "myPublicIP-${format("%02d", count.index)}"

  location            = azurerm_resource_group.vadapav-rg.location

  resource_group_name = azurerm_resource_group.vadapav-rg.name

  allocation_method   = "Dynamic"

}

 

resource "azurerm_network_interface" "vm-nic" {

  count               = var.node_count

  name                = "vm${format("%02d", count.index)}-nic"

  location            = azurerm_resource_group.vadapav-rg.location

  resource_group_name = azurerm_resource_group.vadapav-rg.name

 

  ip_configuration {

    name                          = "internal"

    subnet_id                     = azurerm_subnet.vadapav-sub.id

    private_ip_address_allocation = "Dynamic"

    public_ip_address_id          = element(azurerm_public_ip.vadapav-pip.*.id, count.index)

  }

}

 

resource "azurerm_linux_virtual_machine" "vm1" {

  count                           = var.node_count

  name                            = "vm${format("%02d", count.index)}"

  resource_group_name             = azurerm_resource_group.vadapav-rg.name

  location                        = azurerm_resource_group.vadapav-rg.location

  size                            = "Standard_D2s_v3"

  admin_username                  = "hexagon"

  admin_password                  = "Hexagon@123@terra"

  disable_password_authentication = false

  network_interface_ids = [

    element(azurerm_network_interface.vm-nic.*.id, count.index)

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

 

  custom_data = filebase64("docker.tmpl")

}

