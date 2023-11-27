package com.codesimcoe.quarkus.fx.extension.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class QuarkusFxExtensionResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/quarkus-fx-extension")
                .then()
                .statusCode(200)
                .body(is("Hello quarkus-fx-extension"));
    }
}
