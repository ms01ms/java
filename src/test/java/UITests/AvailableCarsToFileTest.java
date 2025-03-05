package UITests;

import com.hillel.TestSetup;
import com.hillel.FileManager;
import com.hillel.page_objects.HomePage;
import com.hillel.page_objects.InstructionsPage;
import com.hillel.project_config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AvailableCarsToFileTest extends TestSetup {

    @Test
    public void verifyCarListFileSaved() {
        new HomePage()
                .open()
                .clickGuestLoginButton();

        InstructionsPage instructionsPage = new InstructionsPage();
        instructionsPage.clickInstructionsTab()
                .isInstructionTabOpen();
        instructionsPage.clickBrandSelectDropdown();

        List<String> expectedCarBrandNames = instructionsPage.getListOfBrandCarName();

        String filePath = ConfigReader.getProperty("outfile.path");
        Path availableCarFile = Paths.get(filePath);

        try {
            FileManager.writeToFile(availableCarFile, expectedCarBrandNames);
            List<String> actualCarBrandNames = FileManager.readFromFile(availableCarFile);

            Assert.assertEquals(actualCarBrandNames, expectedCarBrandNames,
                    "The contents of the file do not match the expected list of brands");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}


