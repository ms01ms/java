package com.hillel.hw23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GaragePage {

    private WebDriver driver;

    private By addCarButton = By.xpath("//button[contains(@class, 'btn btn-primary')]");
    private By carBrandDropdown = By.xpath("//select[@id='addCarBrand']");
    private By carModelDropdown = By.xpath("//select[@id='addCarModel']");
    private By mileageInput = By.xpath("//input[@id='addCarMileage']");
    private By addButton = By.xpath("(//button[contains(@class, 'btn') and contains(@class, 'btn-primary')])[last()]");
    private By carName = By.xpath("//p[@class='car_name h2']");
    private By mileageDate = By.xpath("//p[@class='car_update-mileage']");
    private By mileageValue = By.xpath("//input[@name='miles']");
    private By carLogo = By.xpath("//img[@class='car-logo_img']");
    private By addedCarInfo = By.xpath("//div[@class='car jumbotron']");


    public GaragePage() {
        this.driver = BrowserFactory.getDriver();
    }

    public GaragePage clickAddCarButton() {
        driver.findElement(this.addCarButton).click();
        return this;
    }

    public GaragePage selectCarBrand(String carBrand) {
        driver.findElement(this.carBrandDropdown).click();
        return this;
    }

    public GaragePage selectCarModel(String carModel) {
        driver.findElement(this.carModelDropdown).click();
        return this;
    }

    public GaragePage selectMileage(String mileageValue) {
        driver.findElement(this.mileageInput).sendKeys(mileageValue);
        return this;
    }

    public GaragePage clickAddButton() {
        driver.findElement(this.addButton).click();
        return this;
    }

    public WebElement getCarName() {
        return driver.findElement(this.carName);
    }

    public WebElement getMileageDate() {
        return driver.findElement(this.mileageDate);
    }

    public WebElement getMileageValue() {
        return driver.findElement(this.mileageValue);
    }

    public WebElement getCarlogo() {
        return driver.findElement(this.carLogo);
    }

    public By getAddedCarInfoXpath() {
        return addedCarInfo;
    }
}
