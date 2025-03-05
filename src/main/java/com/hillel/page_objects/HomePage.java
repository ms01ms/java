package com.hillel.page_objects;

import com.hillel.BrowserFactory;
import com.hillel.project_config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By guestLoginButton = By.xpath("//button[text()='Guest log in']");
    private By signInButton = By.xpath("//button[@class='btn btn-outline-white header_signin']");
    private By email = By.id("signinEmail");
    private By password = By.id("signinPassword");
    private By loginButton = By.xpath("//button[@class='btn btn-primary']");
    private By errorMessage = By.xpath("//p[text()='Wrong email or password']");

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

    public HomePage clickSignInButton() {
        driver.findElement(this.signInButton).click();
        return this;
    }

    public HomePage setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    public HomePage setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        driver.findElement(this.loginButton).click();
        return this;
    }

    public String getErrorMessage() {
       return driver.findElement(this.errorMessage).getText();
    }

    public By getErrorMessageLocator() {
        return this.errorMessage;
    }
}

