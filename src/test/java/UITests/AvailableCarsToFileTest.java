package UITests;

import com.hillel.hw23.BrowserFactory;
import com.hillel.hw23.HomePage;
import com.hillel.hw23.InstructionsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AvailableCarsToFileTest {
    @BeforeClass
    public void setUp() {
        BrowserFactory.createDriver("chrome");
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
    }

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
        } catch (IOException e) {
            Assert.fail("Failed to write or read the file: " + e.getMessage());
        }
    }
}


