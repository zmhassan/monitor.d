FROM docker.io/centos 
MAINTAINER Zak Hassan zak.hassan1010@gmail.com
RUN mkdir -p /app
ADD . /app
WORKDIR /app/app
EXPOSE 8080 
ENTRYPOINT ["python","-m","SimpleHTTPServer","8080"]
