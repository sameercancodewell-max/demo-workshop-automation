package com.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.automation.pages.HomePage;
import com.automation.pages.ILogin;
import com.automation.pages.LandingPage;
import com.automation.pages.LoginPage;


public class DemoWebShopTest extends BaseTest{

    private LandingPage landingPage;
    private ILogin loginPage;
    private HomePage homePage;

    @Test
    public void homePageTitleTest(){

        homePage = new HomePage(driver);
        Assertions.assertEquals("Demo Web Shop", homePage.getPageTitle());
    }

    @Test
    public void loginTest(){

        landingPage = new LandingPage(driver);
        Assertions.assertEquals("Demo Web Shop", landingPage.getPageTitle());
        landingPage.clickLoginLink();

        loginPage = new LoginPage(driver);
        Assertions.assertEquals("Demo Web Shop. Login", loginPage.getPageTitle());
        loginPage.enterEmail(loginData.getEmail());
        loginPage.enterPassword(loginData.getPassword());
        loginPage.clickLoginButton();

        homePage = new HomePage(driver);
        Assertions.assertEquals("Demo Web Shop", homePage.getPageTitle());
        homePage.getWelcomeMessage();
        Assertions.assertEquals("Welcome to our store", homePage.getWelcomeMessage());
    }

}

