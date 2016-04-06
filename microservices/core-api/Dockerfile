FROM docker.io/centos 
MAINTAINER Zak Hassan zak.hassan1010@gmail.com
RUN curl https://nodejs.org/dist/v4.4.2/node-v4.4.2-linux-x64.tar.xz | tar xvfJ - -C /usr/local/
RUN mkdir -p /app
WORKDIR /app
ADD . /app
RUN /usr/local/node-v4.4.2-linux-x64/bin/npm install
EXPOSE 8080 
ENTRYPOINT ["/usr/local/node-v4.4.2-linux-x64/bin/npm", "start"]
