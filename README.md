[![Build Status](https://travis-ci.org/BZCareer/monitor.d.svg?branch=master)](https://travis-ci.org/BZCareer/monitor.d)

##  Problem

Infrastructure setup is difficult in large organizations and they tend to delay projects.  Sometimes there are lots of approval steps to get to production.

In programming we learn the concept of do not repeat yourself. Often times when deploying application it requires developers to explain the process over and over. Sometimes software  requires maintenance and only one person knows how to maintain or deploy something. In the technology space when competition releases a feature, how fast can you catch up? Will it take a week, month or a year. By following devops principles its supposed to reduce the time it takes to go from development to production.

What if there was a better way. What if we had a system that deployed your code up to what ever environment (VM, Kubernetes, Docker Container, Openshift, OpenStack, AWS, On premise dedicated server).

But wait… Isn’t there puppet, ansible, jenkins, etc?

Yes, but looking at the components I was planning on building I don’t see a single product out there that does all the things that this project is planning on doing.

## Warning:

This project is not ready yet. Currently there is no release yet of this project. It's still in development but I will send out a tweet when its ready for use.

## For Builds:

See build.md


## UI Mockup:

![alt tag](https://raw.githubusercontent.com/BZCareer/monitor.d/master/MonitorD-Dash.png)


## Modes:

- Standalone Mode: Using Docker on premise. It will detect the docker registry through environment variable. And let you monitor and manage those containers.
- Cluster Mode : Using Kubernetes or Openshift Origin. In future using Swarm. It will auto discover via environment variables.

## Access Control:

- You can use kubernetes secrets for now or htpassword for creating usernames and passwords that will be used. In the future we may support LDAP, etc.
- Create a user, team structure and provide access controls to the project to individual teams or users.
- These roles will have the following access

     Admin: All access
     Developer: Access to view dashboard and deploy only if approved by admin.
     Analyst: Only dashboard
     Auditor: Able to audit every action done on the application by any user and able to block users access for a period of time.
     Manager: To approve deployments or actions done while monitoring.

## Storage:
- If this is running on Kubernetes it is highly advised to use persistent storage feature (Ceph, Nfs, etc.).
- If standalone it will be running on disk and you will have to do manual mounting of storage.

## Third Party Integration:
- Using swagger you can generate clients in Python, other languages …. See swagger_codegen. I will add documentation around that.

Environment Variables:
MOND_MODE: [Dev, production] - Defaults to production unless otherwise specified by injecting the environment variable into the running docker container.
MOND_DB_PROVIDER - Defaults to MongoDB
MOND_DOCKER_IP - The ip address of the private registry for docker

## MonitorD Go Agent:

- This will be an agent written in go that will feed metrics from a server to monitorD indexer. For environments that are not running on kubernetes or OpenShift v3. You can select to not run the agent and fetch data via ssh like ansible.

## MonitorD Plugins:

- Plugins will provide monitoring for different components.
- In the future I envision that monitor.d will be able to monitor things like:
    -  Cloud:
        - OpenStack
        - OpenShift
        - Kubernetes
        - Docker (Plain)
        - EC2
    - Database:
        - Mongodb.
        - In the future maybe Cassandra, Couchdb, MariaDB, etc.
    -   Storage:
        - Nfs
        - Ceph
        - Hadoop
    - Deployments
        - Ansible
        - In the future maybe Puppet, Chef, etc.
    - JMS:
        - Artemis
        - ActiveMQ
        - HornetQ
    - Application Servers:
        - WildFly
            - Logs
            - JVM
        - Tomcat
    - Spring Boot:
        - Monitor health
        - Metrics


## Selected Database Provider:

- For now its MongoDB but if the community would like to use other databases then feel free to contribute a DBProvider. Also the database will be swappable in the future like cassandra db but I plan on using mongoDB

## Interfaces To Administer Monitor.D:

- CLI
- Web Console
- Rest API

## Components Of MonitorD:
![alt tag](https://raw.githubusercontent.com/BZCareer/monitor.d/master/Components-Design.png)
# Architecture: Standalone Mode:
![alt tag](https://raw.githubusercontent.com/BZCareer/monitor.d/master/Architecture-MonitorKubernetesExternally.png )

## Contributing A Patch

- Submit an issue describing your proposed change to the repo in question.
- I will respond to your issue promptly.
- Fork the desired repo, develop and test your code changes.
- You are free to contribute to any area of code.
- Submit a pull request.
