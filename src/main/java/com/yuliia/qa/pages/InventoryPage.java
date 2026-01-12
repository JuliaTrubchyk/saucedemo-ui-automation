package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;
    private final By inventoryContainer = By.id("inventory_container");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    public void addBackpackToCart(){
        driver.findElement(addBackpackButton).click();
    }

    public CartPage openCart(){
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

}
