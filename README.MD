
## DOCKER DISTROLESS

./mvnw package -Pnative -DskipTests=true -Dnative-image.container-runtime=docker

docker build -f src/main/docker/Dockerfile.distroless -t quarkus/easter-gift .

docker run -i --rm -p 8080:8080 quarkus/getting-started

mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-mariadb"
mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm"
mvn quarkus:add-extension -Dextensions="resteasy-jsonb"
mvn quarkus:add-extension -Dextensions="scheduler"
mvn quarkus:add-extension -Dextensions="smallrye-opentracing"

## TEST

mvn compile quarkus:dev
 
 
 mvn test

