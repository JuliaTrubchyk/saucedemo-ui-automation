package com.yuliia.qa.tests;

import com.yuliia.qa.config.Config;
import com.yuliia.qa.core.BaseTest;
import com.yuliia.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void checkoutHappyPathShouldCompleteOrder(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login(Config.get("username"), Config.get("password"));
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded after login");
        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.openCart();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        Assert.assertTrue(checkoutPage.isLoaded());
        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.submitInfo("Yuliia", "Smith", "12345");
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinish();
        Assert.assertTrue(checkoutCompletePage.isLoaded(), "Checkout complete page should be loaded");
        Assert.assertEquals(checkoutCompletePage.getSuccessText(), "Thank you for your order!");
    }
}
