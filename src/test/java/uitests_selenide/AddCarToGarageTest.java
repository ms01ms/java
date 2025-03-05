package uitests_selenide;

import com.hillel.TestSetup;
import com.hillel.page_objects_selenide.GaragePage;
import com.hillel.page_objects_selenide.HomePage;
import org.testng.annotations.Test;

import static com.hillel.utils.DateUtils.getCurrentDate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddCarToGarageTest extends TestSetup {

    @Test
    public void verifyCarIsAddedToGarage() {
        new HomePage()
                .open()
                .clickGuestLoginButon();

        GaragePage garagePageSelenide = new GaragePage();
        garagePageSelenide.clickAddCarButton()
                .selectCarBrand("Audi")
                .selectCarModel("TT")
                .selectMileage("20")
                .clickAddButton()
                .getAddedCarInfo();

        assertEquals(garagePageSelenide.getCarName().getText(), "Audi TT");
        assertEquals(garagePageSelenide.getMileageDate().getText(), "Update mileage • " + getCurrentDate("dd.MM.yyyy"));
        assertEquals(garagePageSelenide.getMileageValue().getAttribute("valueAsNumber"), "20");
        assertTrue(garagePageSelenide.getCarlogo().isDisplayed(), "Logo does not displayed");
        assertTrue(garagePageSelenide.getCarlogo().getAttribute("src").endsWith("audi.png"));
    }
}
