package com.yuliia.qa.tests;

import com.yuliia.qa.core.BaseTest;
import com.yuliia.qa.pages.InventoryPage;
import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void loginWithValidUserShouldOpenInventoryPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded after login");
    }

    @Test(groups = {"regression"})
    public void loginWithInvalidPasswordShouldShowErrorMessage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessageText().contains("do not match any user"));
    }

    @Test(groups = {"regression"})
    public void loginWithEmptyUsernameShouldShowErrorMessage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessageText().contains("Username is required"));
    }

    @Test(groups = {"regression"})
    public void loginWithEmptyPasswordShouldShowErrorMessage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertTrue(
                loginPage.getErrorMessageText().contains("Password is required"),
                "Expected 'Password is required' error, but got: " + loginPage.getErrorMessageText()
        );
    }
}
