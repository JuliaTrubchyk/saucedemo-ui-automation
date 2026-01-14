package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private final WebDriver driver;
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded(){
        return driver.findElement(continueButton).isDisplayed();
    }

    public void enterFirstName(String firstName){
        WebElement firstNameField = driver.findElement(firstNameInput);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        WebElement lastNameField = driver.findElement(lastNameInput);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode){
        WebElement zipField = driver.findElement(zipCodeInput);
        zipField.clear();
        zipField.sendKeys(zipCode);
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }


    public CheckoutOverviewPage submitInfo(String first, String last, String zip) {
        enterFirstName(first);
        enterLastName(last);
        enterZipCode(zip);
        clickContinue();
        return new CheckoutOverviewPage(driver);
    }
}
