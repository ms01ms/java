package com.hillel.page_objects;

import com.hillel.BrowserFactory;
import com.hillel.project_config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By guestLoginButton = By.xpath("//button[text()='Guest log in']");

    public HomePage() {
        this.driver = BrowserFactory.getDriver();
    }

    public HomePage open() {
        driver.get(ConfigReader.getProperty("base.url"));
        return this;
    }

    public void clickGuestLoginButon() {
        driver.findElement(this.guestLoginButton).click();
    }
}
