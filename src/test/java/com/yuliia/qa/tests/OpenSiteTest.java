package com.yuliia.qa.tests;

import com.yuliia.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.yuliia.qa.core.BaseTest;

public class OpenSiteTest extends BaseTest{
    @Test
    public void openSauceDemoHomePage() {
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonVisible(),
                "Login button should be visible on the login page");
    }
}
