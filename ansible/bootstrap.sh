#!/bin/bash
#
# Author: Zak Hassan

export ANSIBLE_HOST_KEY_CHECKING=False

#sudo yum update -y
#yum install gcc
#curl "https://bootstrap.pypa.io/get-pip.py"  | sudo python   -
#sudo pip install ansible



cat >> /etc/hosts <<EOL

192.168.33.40 hadoopmaster
192.168.33.41 hadoopdata1
192.168.33.42 hadoopdata2

EOL
