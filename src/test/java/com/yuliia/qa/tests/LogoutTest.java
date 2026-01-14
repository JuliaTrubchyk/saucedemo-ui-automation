package com.yuliia.qa.tests;

import com.yuliia.qa.config.Config;
import com.yuliia.qa.core.BaseTest;
import com.yuliia.qa.pages.InventoryPage;
import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void logoutShouldReturnToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login(Config.get("username"), Config.get("password"));
        LoginPage returnedLoginPage = inventoryPage.logout();
        Assert.assertTrue(returnedLoginPage.isLoginButtonVisible(), "Login button should be visible after logout");
    }
}
