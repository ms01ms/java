package UITests;

import com.hillel.TestSetup;
import com.hillel.FileManager;
import com.hillel.page_objects.HomePage;
import com.hillel.page_objects.InstructionsPage;
import com.hillel.project_config.ConfigReader;
import com.hillel.waitelement.WaitElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileDownloadTest extends TestSetup {

    @Test
    public void verifyFileDownloadOnInstructionsPage() {
        new HomePage()
                .open()
                .clickGuestLoginButton();

        InstructionsPage instructionsPage = new InstructionsPage();
        instructionsPage.clickInstructionsTab()
                .isInstructionTabOpen();
        instructionsPage.downloadInstruction();


        String downloadPath = ConfigReader.getProperty("download.dir");
        String expectedFileName = "Front windshield wipers on Audi TT.pdf";

        try {
            FileManager.forceDeleteFile(downloadPath, expectedFileName);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        boolean isFileDownloaded = WaitElement.waitForFileDownload(downloadPath, expectedFileName, 20);
        Assert.assertTrue(isFileDownloaded, "File " + expectedFileName + " was not downloaded");

        File downloadedFilePath = new File(downloadPath);
        File[] listDownloadedFiles = downloadedFilePath.listFiles();

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

