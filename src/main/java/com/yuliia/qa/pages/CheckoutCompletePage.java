package com.yuliia.qa.pages;

import com.yuliia.qa.utils.Waits;
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
        return Waits.visible(driver, successText).getText();
    }

    public boolean isLoaded() {
        return Waits.visible(driver, successText).isDisplayed();
    }

}
