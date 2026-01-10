package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final String url = "https://www.saucedemo.com/";

    // locators:
    private final By loginButton = By.id("login-button");
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void enterUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public boolean isLoginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public InventoryPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage(driver);
    }

}
