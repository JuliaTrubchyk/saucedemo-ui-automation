package com.yuliia.qa.listeners;

import com.yuliia.qa.core.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener extends TestListenerAdapter {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();

        if (!(testInstance instanceof BaseTest)) {
            return; // safety: if some test doesn't extend BaseTest
        }

        WebDriver driver = ((BaseTest) testInstance).getDriver();
        if (driver == null) {
            return;
        }

        if (!(driver instanceof TakesScreenshot)) {
            return;
        }

        try {
            String timestamp = LocalDateTime.now().format(FORMATTER);
            String testName = result.getTestClass().getName() + "." + result.getMethod().getMethodName();
            String fileName = testName.replaceAll("[^a-zA-Z0-9._-]", "_") + "_" + timestamp + ".png";

            Path screenshotsDir = Path.of("target", "screenshots");
            Files.createDirectories(screenshotsDir);

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = screenshotsDir.resolve(fileName);

            Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Saved screenshot: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
