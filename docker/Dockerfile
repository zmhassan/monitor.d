FROM centos

# add our user and group first to make sure their IDs get assigned consistently, regardless of whatever dependencies get added
RUN groupadd -r monitord && useradd -r -g monitord monitord

RUN mkdir /docker-entrypoint-initdb.d

ENV MONITORD_MAJOR 1.0
ENV MONITORD_VERSION 1.0.0-SNAPSHOT

VOLUME /var/lib/monitord

COPY docker-entrypoint.sh /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 3000
CMD ["monitord"]
