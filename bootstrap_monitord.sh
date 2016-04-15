#!/bin/bash
#
# Author: Zak Hassan



curl -fsSL https://get.docker.com/ | sh

sudo usermod -aG docker vagrant

sudo systemctl enable docker
sudo systemctl start docker
sudo yum install haproxy -y
sudo yum install wget -y

sudo cat /vagrant/config/haproxy.cfg > /etc/haproxy/haproxy.cfg
sudo systemctl enable haproxy
sudo systemctl start haproxy

# Downloading Docker Images required for stack
sudo docker pull mongo
sudo docker pull java:8-jdk-alpine
sudo docker pull google/nodejs
sudo docker pull centos


# Installing pip :
curl "https://bootstrap.pypa.io/get-pip.py"  | sudo python   -
sudo pip install docker-compose

# Tools for Node Development
sudo yum install npm -y
sudo npm install -g http-server
sudo npm install -g json

echo 'export MOND_MODE="DEV"' >> /home/vagrant/.bashrc  


echo 'export MON_IP="192.168.33.10"' >> /home/vagrant/.bashrc  
echo 'export INIT_MONGO_IP="spring.data.mongodb.uri=mongodb://$MON_IP:27017/mydb"' >> /home/vagrant/.bashrc  
