#!/bin/bash
#MONGO_IP=$(echo $DOCKER_HOST | awk -F'[:  /]+' '{ print $2 }')
#SPRING_MONGO_IP="mongodb://":$MONGO_IP:":27017/mydb"
#export HOST_MONGO_IP="mongo "$MONGO_IP
export MON_IP=$(docker-machine ip)
export INIT_MONGO_IP="spring.data.mongodb.uri=mongodb://$MON_IP:27017/mydb"
docker-compose -f ../docker-compose.yml  up -d
