package com.hillel.page_objects;

import com.hillel.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InstructionsPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    private By instructionsTab = By.xpath("//a[@class='btn btn-white btn-sidebar sidebar_btn'][last()]");
    private By brandSelectDropdown = By.xpath("//button[@id='brandSelectDropdown']");
    private By brandSelectDropdownMenu = By.cssSelector(".brand-select-dropdown_item");
    private By instructionDownloadLink = By.xpath("//p[contains(text(), 'Front windshield wipers on Audi TT')]/following-sibling::a[contains(@class, 'instruction-link_download')]");


    public InstructionsPage() {
        this.driver = BrowserFactory.getDriver();
    }

    public InstructionsPage clickInstructionsTab() {
        driver.findElement(this.instructionsTab).click();
        return this;
    }

    public void isInstructionTabOpen() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(instructionDownloadLink));

    }

    public InstructionsPage clickBrandSelectDropdown() {
        driver.findElement(this.brandSelectDropdown).click();
        return this;
    }

    public List<String> getListOfBrandCarName() {
        List<WebElement> carBrands = driver.findElements((this.brandSelectDropdownMenu));
        List<String> carBrandNames = new ArrayList<>();

        for (WebElement brand : carBrands) {
            carBrandNames.add(brand.getText());
        }
        return carBrandNames;
    }

    public InstructionsPage downloadInstruction() {
        driver.findElement(this.instructionDownloadLink).click();
        return this;
    }
}
