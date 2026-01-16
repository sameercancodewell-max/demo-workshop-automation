package com.automation.pages;

public interface ILogin {
    String getPageTitle();
    void enterEmail(String email);
    void enterPassword(String password);
    void clickLoginButton();
}
