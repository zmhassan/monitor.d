#!/bin/bash
#
# Author: Zak Hassan

# This IP address is the private ip create by the vagrant box. If you change your vagrant file you will have to update this as well.
export MON_IP="192.168.33.10"

export INIT_MONGO_IP="spring.data.mongodb.uri=mongodb://$MON_IP:27017/mydb"

docker-compose    -f    /vagrant/docker-compose.yml    up    -d
