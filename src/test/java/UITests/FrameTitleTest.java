package UITests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameTitleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyFrameTitle() {
        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src, 'youtube.com')]"));
        driver.switchTo().frame(iframe);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String iframeTitle = (String) js.executeScript("return document.title;");
        String expectedIframeTitle = "Як потрапити у майбутнє? Трансформація навчання. - YouTube";

        if (!iframeTitle.equals(expectedIframeTitle)) {
            Reporter.log("Title doesn’t equals to the expected result: " + iframeTitle, true);
        }

        Assert.assertEquals(iframeTitle, expectedIframeTitle, "Title doesn’t equals to the expected result");
    }
}
