package nz.fiore.service.rs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

@QuarkusTest
public class PrintServiceRsTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/print")
                .then()
                .statusCode(200)
                .body(is("hello quarkus"));
    }

    @Test
    public void testHealthEndpoint() {
        given()
                .when().get("/health")
                .then()
                .statusCode(200)
                .body(allOf(containsString("UP")));
    }

}
