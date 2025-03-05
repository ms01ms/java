package UITests;

import com.aventstack.extentreports.ExtentTest;
import com.hillel.*;
import com.hillel.page_objects.GaragePage;
import com.hillel.page_objects.HomePage;
import com.hillel.waitelement.WaitElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hillel.ExtentReportManager.getTest;
import static com.hillel.utils.DateUtils.getCurrentDate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class AddCarToGarageTest extends TestSetup {

    private ExtentTest test;

    @Test
    public void verifyCarIsAddedToGarage() {
        test = ExtentReportManager.createTest("verifyCarIsAddedToGarage")
                .assignAuthor("Mira")
                .assignDevice("Mac M2");

        getTest().info("Test verifyCarIsAddedToGarage started");

        new HomePage()
                .open()
                .clickGuestLoginButton();

        ExtentReportManager.captureScreenshot(BrowserFactory.getDriver(), "test1_screenshot");

        GaragePage garagePage = new GaragePage();

        ExtentReportManager.captureScreenshot(BrowserFactory.getDriver(), "test2_screenshot");

        garagePage.clickAddCarButton()
                .selectCarBrand("Audi")
                .selectCarModel("TT")
                .selectMileage("20")
                .clickAddButton();
        ExtentReportManager.captureScreenshot(BrowserFactory.getDriver(), "test3_screenshot");

        WaitElement.waitForVisibilityOfElementLocated(garagePage.getAddedCarInfoXpath(), 10);

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


