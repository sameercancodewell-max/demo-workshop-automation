package com.automation.apiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;

import com.automation.api.BaseAPiTest;

public class DemoWebShopApiTest extends BaseAPiTest {

    @Test
    public void testHomePageAPi(){
        given()
        .when()
            .get("/")
        .then()
            .statusCode(200)
            .body(containsString("Demo Web Shop"));
    }

}
