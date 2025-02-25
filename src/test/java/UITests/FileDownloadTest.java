package UITests;

import com.hillel.hw23.BrowserFactory;
import com.hillel.hw23.HomePage;
import com.hillel.hw23.InstructionsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest {

    @BeforeClass
    public void setUp() {
        BrowserFactory.createDriver("chrome");
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
    }

    @Test
    public void verifyFileDownloadOnInstructionsPage() {
        new HomePage()
                .open()
                .clickGuestLoginButon();

        InstructionsPage instructionsPage = new InstructionsPage();
        instructionsPage.clickInstructionsTab()
                .isInstructionTabOpen();
        instructionsPage.downloadInstruction();

        File downloadedFilePath = new File(BrowserFactory.getDownloadDir());

        File[] listDownloadedFiles = downloadedFilePath.listFiles();

        String expectedFileName = "Front windshield wipers on Audi TT.pdf";

        boolean downloadedFileName = false;
        if (listDownloadedFiles != null) {
            for (File file : listDownloadedFiles) {
                if (file.getName().equals(expectedFileName)) {
                    downloadedFileName = true;
                    break;
                }
            }
        }

        Assert.assertTrue(downloadedFileName, "File " + expectedFileName + " was not downloaded to the target folder");
    }
}

