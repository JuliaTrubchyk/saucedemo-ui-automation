package com.yuliia.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.yuliia.qa.core.BaseTest;

public class OpenSiteTest extends BaseTest{
    @Test
    public void openSauceDemoHomePage(){
            driver.get("https://www.saucedemo.com/"); // Open page
            WebElement loginButton = driver.findElement(By.id("login-button"));
            Assert.assertTrue(loginButton.isDisplayed(), "Login button should be visible on the login page");
    }
}
