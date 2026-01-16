package com.automation.apiTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.automation.util.PostgresDBUtil;

public class DatabaseValidationTest {

    @Test
    public void testUserExistsInDB(){
         String testEmail = "eve.holt@reqres.in"; // Use a real email from your DB
         boolean exists = PostgresDBUtil.validateUserExists(testEmail);
         assertTrue(exists, "User should exist in the database");
    }
    
}
