package UITests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hillel.hw23.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.hillel.hw23.DateUtils.getCurrentDate;
import static com.hillel.hw23.ExtentReportManager.getTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class AddCarToGarageTest {

    private static WebDriverWait wait;
    private ExtentReports extentReport;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        BrowserFactory.createDriver("chrome");
        wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(10));
        extentReport = ExtentReportManager.getInstance();
    }

    @AfterClass
    public void tearDown() {
        ExtentReportManager.finishTest();
        BrowserFactory.quitDriver();
    }

    @Test
    public void verifyCarIsAddedToGarage() {
        test = ExtentReportManager.createTest("verifyCarIsAddedToGarage")
                .assignAuthor("Mira")
                .assignDevice("Mac M2");

        getTest().info("Test verifyCarIsAddedToGarage started");

        new HomePage()
                .open()
                .clickGuestLoginButon();
        ExtentReportManager.captureScreenshot(BrowserFactory.getDriver(), "test1_screenshot");


        GaragePage garagePage = new GaragePage();
        ExtentReportManager.captureScreenshot(BrowserFactory.getDriver(), "test2_screenshot");
        garagePage.clickAddCarButton()
                .selectCarBrand("Audi")
                .selectCarModel("TT")
                .selectMileage("20")
                .clickAddButton();
        ExtentReportManager.captureScreenshot(BrowserFactory.getDriver(), "test3_screenshot");

        wait.until(ExpectedConditions.visibilityOfElementLocated(garagePage.getAddedCarInfoXpath()));

        try {
            assertEquals(garagePage.getCarName().getText(), "Audi TT");
            test.pass("Car name verified");

            assertEquals(garagePage.getMileageDate().getText(), "Update mileage • " + getCurrentDate("dd.MM.yyyy"));
            test.pass("Mileage date verified");

            assertEquals(garagePage.getMileageValue().getAttribute("valueAsNumber"), "20");
            test.pass("Car mileage verified");

            assertTrue(garagePage.getCarlogo().isDisplayed(), "Logo does not displayed");
            test.pass("Car logo is displayed");

            assertTrue(garagePage.getCarlogo().getAttribute("src").endsWith("audi.png"));
            test.pass("Logo source is correct");
        } catch (Exception exception) {
            ExtentReportManager.getTest().fail(exception.getMessage());
        }
    }
}


