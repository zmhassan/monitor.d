#!/bin/bash
#
# Author: Zak Hassan



curl -fsSL https://get.docker.com/ | sh

sudo usermod -aG docker vagrant

sudo systemctl enable docker
sudo systemctl start docker
sudo dnf install haproxy -y

# Downloading Docker Images required for stack
sudo docker pull mongo
sudo docker pull java:8-jdk-alpine
sudo docker pull google/nodejs

sudo pip install docker-compose

sudo dnf install npm

sudo npm install -g http-server
sudo npm install -g json

export MON_IP="192.168.33.10"
export INIT_MONGO_IP="spring.data.mongodb.uri=mongodb://$MON_IP:27017/mydb"
