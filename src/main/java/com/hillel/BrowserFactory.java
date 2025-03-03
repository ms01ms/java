package com.hillel;

import com.codeborne.selenide.WebDriverRunner;
import com.hillel.project_config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    private static WebDriver driver;

    public static void createDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.default_directory", ConfigReader.getProperty("download.dir"));

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                WebDriverRunner.setWebDriver(driver);
                break;
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new InvalidArgumentException(String.format("Unsupported browser " + browserName));
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
