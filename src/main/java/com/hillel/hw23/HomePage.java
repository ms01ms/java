package com.hillel.hw23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By guestLoginButton = By.xpath("//button[text()='Guest log in']");

    public HomePage() {
        this.driver = BrowserFactory.getDriver();
    }

    public HomePage open() {
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        return this;
    }

    public void clickGuestLoginButon() {
        driver.findElement(this.guestLoginButton).click();
    }
}
