
## easter gift: quakus => hibernate, resteasy. scheduler, cdi, health TEST


./mvnw package -Pnative -DskipTests=true -Dnative-image.container-runtime=docker

to create docker image with distroless image
docker build -f src/main/docker/Dockerfile.distroless -t quarkus/easter-gift .

docker-compose -f docker/docker-compose_complete.yml up


## RUN
mvn compile quarkus:dev
 
## EXTENSION USED
 mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-mariadb"
 mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm"
 mvn quarkus:add-extension -Dextensions="resteasy-jsonb"
 mvn quarkus:add-extension -Dextensions="scheduler"
 mvn quarkus:add-extension -Dextensions="smallrye-opentracing"

## TEST
 mvn test

