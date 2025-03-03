package com.hillel.page_objects_selenide;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.hillel.project_config.ConfigReader;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private SelenideElement guestLoginButton = $x("//button[text()='Guest log in']");

    public HomePage open() {
        WebDriverRunner.getWebDriver().get(ConfigReader.getProperty("base.url"));
        return this;
    }

    public void clickGuestLoginButon() {
        guestLoginButton.click();
    }
}
