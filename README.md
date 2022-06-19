# Spring in Action 6th Edition - Sample Code

This is the sample code for Spring in Action, 6th Edition, by Craig Walls.

- [x] Spring Boot
- [X] Lombok
- [X] Spring Boot Starter Validation
- [X] [JDBC](https://github.com/canessaalvamiguel/spring-in-action-6th/tree/tacocloud-Using-relational-db-h2-spring-data-jdbc)
- [x] [JPA](https://github.com/canessaalvamiguel/spring-in-action-6th/tree/tacocloud-Using-relational-db-h2-spring-data-jpa)
- [x] Hibernate
- [X] [Cassandra](https://github.com/canessaalvamiguel/spring-in-action-6th/tree/tacocloud-Using-noSql-Apache-Cassandra)

### Available entry URL
- http://localhost:8080/
- http://localhost:8080/design

### Steps to create casandra db usign docker

```
$ docker network create cassandra-net
$ docker run --name my-cassandra \
--network cassandra-net \
-p 9042:9042 \
-d cassandra:latest
```

Accessing the docker:

```
$ docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra
```

Creating keyspace:

```
cqlsh> create keyspace tacocloud
... with replication={'class':'SimpleStrategy', 'replication_factor':1}
... and durable_writes=true;
```
