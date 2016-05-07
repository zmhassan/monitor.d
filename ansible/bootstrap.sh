#!/bin/bash
#
# Author: Zak Hassan

export ANSIBLE_HOST_KEY_CHECKING=False

#sudo yum group install "Development Tools" -y
sudo yum install epel-release -y
sudo yum install ansible -y
 


cat >> /etc/hosts <<EOL

192.168.33.40 hadoopmaster
192.168.33.41 hadoopdata1
192.168.33.42 hadoopdata2

EOL
