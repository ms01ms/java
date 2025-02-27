package UITests;

import com.hillel.BaseTest;
import com.hillel.page_objects.HomePage;
import com.hillel.page_objects.InstructionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AvailableCarsToFileTest extends BaseTest {

    @Test
    public void verifyCarListFileSaved() {
        new HomePage()
                .open()
                .clickGuestLoginButon();

        InstructionsPage instructionsPage = new InstructionsPage();
        instructionsPage.clickInstructionsTab()
                .isInstructionTabOpen();
        instructionsPage.clickBrandSelectDropdown();

        List<String> expectedCarBrandNames = instructionsPage.getListOfBrandCarName();
        Path availableCarFile = Paths.get("target/availableCarFile.txt");

        try {
            Files.write(availableCarFile, expectedCarBrandNames);
            List<String> actualCarBrandNames = Files.readAllLines(availableCarFile);
            Assert.assertEquals(actualCarBrandNames, expectedCarBrandNames,
                    "The contents of the file do not match the expected list of brands");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}


