package UITests;

import com.hillel.hw23.BrowserFactory;
import com.hillel.hw23.GaragePage;
import com.hillel.hw23.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.hillel.hw23.DateUtils.getCurrentDate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddCarToGarageTest {

    private static WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        BrowserFactory.createDriver("chrome");
        wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
    }

    @Test
    public void verifyCarIsAddedToGarage() throws InterruptedException {
        new HomePage()
                .open()
                .clickGuestLoginButon();

        GaragePage garagePage = new GaragePage();
        garagePage.clickAddCarButton()
                .selectCarBrand("Audi")
                .selectCarModel("TT")
                .selectMileage("20")
                .clickAddButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(garagePage.getAddedCarInfoXpath()));

        assertEquals(garagePage.getCarName().getText(), "Audi TT");
        assertEquals(garagePage.getMileageDate().getText(), "Update mileage • " + getCurrentDate("dd.MM.yyyy"));
        assertEquals(garagePage.getMileageValue().getAttribute("valueAsNumber"), "20");
        assertTrue(garagePage.getCarlogo().isDisplayed(), "Logo does not displayed");
        assertTrue(garagePage.getCarlogo().getAttribute("src").endsWith("audi.png"));
    }
}
