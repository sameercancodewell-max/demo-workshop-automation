package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage implements ILogin{

    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.className("login-button");
    
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getPageTitle(){
        return driver.getTitle();
    }

    @Override
    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Override
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    @Override
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}
