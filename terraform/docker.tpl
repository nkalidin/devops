#!/bin/bash
sudo apt update -y
sudo apt install docker* -y
sudo mkdir /dba
sudo echo Hello world1 > /dba/index.html
sudo docker run -d --name=terraform1 -p 7777:80 -v /dba:/usr/share/nginx/html nginx:latest 
