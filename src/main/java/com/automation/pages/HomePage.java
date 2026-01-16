package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final By welcomeMessage = By.xpath("//h2[contains(text(),'Welcome to our store')]");

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
}
