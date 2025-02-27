package UITests;

import com.hillel.BaseTest;
import com.hillel.page_objects.HomePage;
import com.hillel.page_objects.InstructionsPage;
import com.hillel.project_config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    @Test
    public void verifyFileDownloadOnInstructionsPage() {
        new HomePage()
                .open()
                .clickGuestLoginButon();

        InstructionsPage instructionsPage = new InstructionsPage();
        instructionsPage.clickInstructionsTab()
                .isInstructionTabOpen();
        instructionsPage.downloadInstruction();

        File downloadedFilePath = new File(ConfigReader.getProperty("download.dir"));

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

