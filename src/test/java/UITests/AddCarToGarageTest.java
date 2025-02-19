package UITests;

import com.hillel.hw23.BrowserFactory;
import com.hillel.hw23.GaragePage;
import com.hillel.hw23.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddCarToGarageTest {

    @BeforeClass
    public void setUp() {
        BrowserFactory.createDriver("chrome");
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

        BrowserFactory.getWait().until(ExpectedConditions.visibilityOfElementLocated(garagePage.getAddedCarInfoXpath()));

        assertEquals(garagePage.getCarName().getText(), "Audi TT");
        assertEquals(garagePage.getMileageDate().getText(), "Update mileage • " + getCurrentDate());
        assertEquals(garagePage.getMileageValue().getAttribute("valueAsNumber"), "20");
        assertTrue(garagePage.getCarlogo().isDisplayed(), "Logo does not displayed");
        assertTrue(garagePage.getCarlogo().getAttribute("src").endsWith("audi.png"));
    }

    private String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return today.format(formatter);
    }
}
