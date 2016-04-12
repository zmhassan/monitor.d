#!/bin/bash
#MONGO_IP=$(echo $DOCKER_HOST | awk -F'[:  /]+' '{ print $2 }')
#SPRING_MONGO_IP="mongodb://":$MONGO_IP:":27017/mydb"
#export HOST_MONGO_IP="mongo "$MONGO_IP

docker-compose -f ../docker-compose.yml  up -d
