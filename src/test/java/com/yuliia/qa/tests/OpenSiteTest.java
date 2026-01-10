package com.yuliia.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSiteTest {
    @Test
    public void openSauceDemoHomePage(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com/"); // Open page
            String title = driver.getTitle(); // returns the tab title
            Assert.assertEquals(title, "Swag Labs"); // check so we have 1 assertion
        } finally {
            driver.quit();
        }
    }
}
