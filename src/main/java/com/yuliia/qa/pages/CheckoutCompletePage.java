package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private final WebDriver driver;
    private final By backHomeButton = By.id("back-to-products");
    private final By successText = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessText() {
        return driver.findElement(successText).getText();
    }

    public boolean isLoaded() {
        return driver.findElement(successText).isDisplayed();
    }

}
