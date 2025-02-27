package com.hillel.waitelement;

import com.hillel.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitElement {

    public static WebElement waitForVisibilityOfElementLocated(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementToDisappear(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForTextToBePresent(By locator, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.textToBe(locator, text));
    }
}
