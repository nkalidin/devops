terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "4.82.0"
    }
  }
}
provider "google" {
  credentials = file("fractal3-eafc5ce054943.json")
  project     = "fractal3"
  region      = "us-central1"
}

# resource "google_service_account" "default" {
#   account_id   = "vmaccount"
#   display_name = "Service Account"
#   project      = "projecta-398915"
# }

resource "google_compute_instance" "vm1" {
  project      = "fractal3"
  name         = "vm1"
  machine_type = "e2-medium"
  zone         = "us-central1-b"
  tags         = ["app", "prod"]
  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-11"
      labels = {
        app = "proddisk"
      }
    }
  }
  network_interface {
    network = "default"
    access_config {
    }
  }
}


