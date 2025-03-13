package com.hillel;

import com.codeborne.selenide.WebDriverRunner;
import com.hillel.project_config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
				options.setCapability("selenoid:options", new HashMap<String, Object>() {{
					put("sessionTimeout", "15m");
					put("enableVideo", true);
				}});

				//for local launch
//				driver = new ChromeDriver(options);

				//for remote launch
				try {
					System.out.println("===remote.url===" + ConfigReader.getProperty("remote.url"));
					driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("remote.url")), options);
				} catch (MalformedURLException e) {
					throw new RuntimeException();
				}

				driver.manage().window().maximize();
				WebDriverRunner.setWebDriver(driver);
				break;
			case ("firefox"):
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability("browserVersion", "124.0");
				firefoxOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
					put("sessionTimeout", "15m");
					put("enableVideo", true);
				}});

				//for local launch
//				driver = new FirefoxDriver();

				//for remote launch
				try {
					driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("remote.url")), firefoxOptions);
				} catch (MalformedURLException e) {
					throw new RuntimeException();
				}

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
