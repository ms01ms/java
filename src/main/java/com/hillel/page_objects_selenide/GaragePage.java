package com.hillel.page_objects_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GaragePage {
    private SelenideElement addCarButton = $x("//button[contains(@class, 'btn btn-primary')]");
    private SelenideElement carBrandDropdown = $x("//select[@id='addCarBrand']");
    private SelenideElement carModelDropdown = $x("//select[@id='addCarModel']");
    private SelenideElement mileageInput = $x("//input[@id='addCarMileage']");
    private SelenideElement addButton = $x("(//button[contains(@class, 'btn') and contains(@class, 'btn-primary')])[last()]");
    private SelenideElement carName = $x("//p[@class='car_name h2']");
    private SelenideElement mileageDate = $x("//p[@class='car_update-mileage']");
    private SelenideElement mileageValue = $x("//input[@name='miles']");
    private SelenideElement carLogo = $x("//img[@class='car-logo_img']");
    private SelenideElement addedCarInfo = $x("//div[@class='car jumbotron']");

    public GaragePage clickAddCarButton() {
        addCarButton.click();
        return this;
    }

    public GaragePage selectCarBrand(String carBrand) {
        carBrandDropdown.click();
        return this;
    }

    public GaragePage selectCarModel(String carModel) {
        carModelDropdown.click();
        return this;
    }

    public GaragePage selectMileage(String mileageValue) {
        this.mileageInput.setValue(mileageValue);
        return this;
    }

    public GaragePage clickAddButton() {
        addButton.click();
        return this;
    }

    public SelenideElement getCarName() {
        return this.carName;
    }

    public SelenideElement getMileageDate() {
        return this.mileageDate;
    }

    public SelenideElement getMileageValue() {
        return this.mileageValue;
    }

    public SelenideElement getCarlogo() {
        return this.carLogo;
    }

    public SelenideElement getAddedCarInfo() {
        return addedCarInfo.shouldBe(Condition.visible);
    }
}
