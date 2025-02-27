package UITests;

import com.hillel.BrowserFactory;
import com.hillel.BaseTest;
import com.hillel.page_objects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FrameTitleTest extends BaseTest {

    @Test
    public void verifyFrameTitle() {
        new HomePage()
                .open();

        WebElement iframe = BrowserFactory.getDriver().findElement(By.xpath("//iframe[contains(@src, 'youtube.com')]"));
        BrowserFactory.getDriver().switchTo().frame(iframe);
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        String iframeTitle = (String) js.executeScript("return document.title;");
        String expectedIframeTitle = "Як потрапити у майбутнє? Трансформація навчання. - YouTube";

        if (!iframeTitle.equals(expectedIframeTitle)) {
            Reporter.log("Title doesn’t equals to the expected result: " + iframeTitle, true);
        }

        Assert.assertEquals(iframeTitle, expectedIframeTitle, "Title doesn’t equals to the expected result");
    }
}
