package com.yuliia.qa.pages;

import com.yuliia.qa.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private final WebDriver driver;
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return Waits.visible(driver, finishButton).isDisplayed();
    }

    public CheckoutCompletePage clickFinish() {
        Waits.clickable(driver, finishButton).click();
        return new CheckoutCompletePage(driver);
    }

}
