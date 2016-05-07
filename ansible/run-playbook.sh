#!/bin/bash
#
# Author: Zak Hassan
export ANSIBLE_HOST_KEY_CHECKING=False

ansible-playbook -i invm.yml  site.yml
