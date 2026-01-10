package com.yuliia.qa.tests;

import com.yuliia.qa.core.BaseTest;
import com.yuliia.qa.pages.InventoryPage;
import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithValidUserShouldOpenInventoryPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded after login");
    }

    @Test
    public void loginWithInvalidPasswordShouldShowErrorMessage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessageText().contains("do not match any user"));
    }
}
