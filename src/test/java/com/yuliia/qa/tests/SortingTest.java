package com.yuliia.qa.tests;

import com.yuliia.qa.config.Config;
import com.yuliia.qa.core.BaseTest;
import com.yuliia.qa.pages.InventoryPage;
import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest extends BaseTest {
    @Test(groups = {"regression"})
    public void sortByPriceLowToHighShouldOrderPricesAscending() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        InventoryPage inventoryPage = loginPage.login(Config.get("username"), Config.get("password"));
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded after login");

        inventoryPage.sortByVisibleText("Price (low to high)");

        List<Double> prices = inventoryPage.getItemPrices();
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);

        Assert.assertEquals(prices, sorted, "Prices should be sorted ascending");
    }

}
