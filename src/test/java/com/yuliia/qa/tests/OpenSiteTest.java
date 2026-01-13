package com.yuliia.qa.tests;

import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.yuliia.qa.core.BaseTest;

public class OpenSiteTest extends BaseTest{
    @Test(groups = {"smoke", "regression"})
    public void openSauceDemoHomePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoginButtonVisible(),
                "Login button should be visible on the login page");
    }
}
