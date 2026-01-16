package com.automation.api;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

public abstract class BaseAPiTest {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }
    
}
