package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final By cartContainer = By.id("cart_contents_container");
    private final By cartItemNames = By.className("inventory_item_name");
    private final By cartItems = By.className("cart_item");
    private final By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    private final By checkoutButton = By.id("checkout");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return driver.findElement(cartContainer).isDisplayed();
    }

    public boolean hasItemNamed(String expectedName) {
        return driver.findElements(cartItemNames).stream()
                .anyMatch(element -> element.getText().equals(expectedName));
    }

    public void removeBackpack(){
        driver.findElement(removeBackpackButton).click();
    }

    public boolean isEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    public CheckoutPage goToCheckout(){
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }

}
