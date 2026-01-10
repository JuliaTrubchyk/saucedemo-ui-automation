package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // locator: how to find the login button
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
