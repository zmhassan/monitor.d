
## How to contribute:

Monitor.d is Apache 2.0 licensed and accepts contributions via GitHub pull requests. This document outlines some of the conventions on commit message formatting, contact points for developers and other resources to make getting your contribution into monitor.d easier.


## Continuous Integration:

When code pull requests are sent test will run from Travis-ci:

   https://travis-ci.org/BZCareer/monitor.d   

## Building UI:

```bash
cd web;
npm install;
npm start
```
Navigate to http://localhost:8080


## Building Backend:

```
mvn clean install
# Note: You will have to have mongodb running on localhost.
```


## Docker Images Are on Docker Hub:

Not ready yet.

Frontend:   https://hub.docker.com/r/bzcareer/monitord/  
Backend:   https://hub.docker.com/r/bzcareer/monitord-core-api/  


## Use /bin to Start/Stop full containerized app (with backend/db/frontend/proxy):

./bin/start.sh

Starts 4 containers:

*  Nginx
*  MongoDB
*  Frontend
*  Backend

To stop containers running:

./bin/stop.sh

You will be able to see the ui running on the same ip as your DOCKER_HOST

http://$DOCKER_HOST:80/

### Backend:
http://$DOCKER_HOST:80/api

### Debugging:
To verify if the backend is up and running visit:

http://$DOCKER_HOST:80/health  


## Mailing List:

To start discussions open a topic here:

https://groups.google.com/d/forum/monitord
