package com.yuliia.qa.tests;

import com.yuliia.qa.core.BaseTest;
import com.yuliia.qa.pages.CartPage;
import com.yuliia.qa.pages.InventoryPage;
import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {

    @Test
    public void addProductToCartAndOpenCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.openCart();
        Assert.assertTrue(cartPage.isLoaded(), "Cart page should be loaded");
        Assert.assertTrue(cartPage.hasItemNamed("Sauce Labs Backpack"),
                "Expected 'Sauce Labs Backpack' to be present in the cart");
    }

    @Test
    public void removeItemFromCartShouldMakeCartEmpty(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.openCart();
        cartPage.removeBackpack();
        Assert.assertTrue(cartPage.isEmpty(), "Cart should be empty after removing an item");
    }
}

