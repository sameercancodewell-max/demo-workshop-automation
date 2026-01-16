package com.automation.apiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

public class ReqresApiTest {

    @Test
    public void testLoginApi(){
        given()
            .baseUri("https://reqres.in")
            .contentType("application/json")
            .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
        .when()
            .post("/api/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue());
    }

    @Test
    public void testGetUserApi(){
        given()
            .baseUri("https://reqres.in")
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }

}
