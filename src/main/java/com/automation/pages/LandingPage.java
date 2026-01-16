package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

    private final By loginLink = By.xpath("//*[contains(text(),'Log in')]");

    public LandingPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

   
    
}
