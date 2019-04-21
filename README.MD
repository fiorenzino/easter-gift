
## easter gift: quakus => hibernate, resteasy, scheduler, cdi, health, tracing


./mvnw package -Pnative -DskipTests=true -Dnative-image.container-runtime=docker

to create docker image with distroless image
docker build -f src/main/docker/Dockerfile.distroless -t quarkus/easter-gift .

docker-compose -f docker/docker-compose_complete.yml up


## RUN
Start mariadb(mysql), phpmyadmin and jaegertracing, using docker compose:
docker-compose -f docker/docker-compose.yml up

and after:

mvn compile quarkus:dev
 
## EXTENSION USED
 mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-mariadb"
 mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm"
 mvn quarkus:add-extension -Dextensions="resteasy-jsonb"
 mvn quarkus:add-extension -Dextensions="scheduler"
 mvn quarkus:add-extension -Dextensions="smallrye-opentracing"

## TEST
Start mariadb(mysql), phpmyadmin and jaegertracing, using docker compose:
docker-compose -f docker/docker-compose.yml up

 mvn test


## LIMITED SIZE

53M ====> easter-gift-1.0-SNAPSHOT-runner
