package com.yuliia.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.yuliia.qa.utils.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class InventoryPage {

    private final WebDriver driver;
    private final By inventoryContainer = By.id("inventory_container");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By sortDropdown = By.className("product_sort_container");
    private final By itemNames = By.className("inventory_item_name");
    private final By itemPrices = By.className("inventory_item_price");

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

    public void clickMenuButton(){
        driver.findElement(menuButton).click();
    }

    public LoginPage logout(){
        clickMenuButton();
        Waits.clickable(driver, logoutLink).click();
        return new LoginPage(driver);
    }

    public void sortByVisibleText(String optionText) {
        WebElement dropdown = Waits.clickable(driver, sortDropdown);
        new Select(dropdown).selectByVisibleText(optionText);
    }

    public List<String> getItemNames() {
        return driver.findElements(itemNames).stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getItemPrices() {
        return driver.findElements(itemPrices).stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();
    }
}
