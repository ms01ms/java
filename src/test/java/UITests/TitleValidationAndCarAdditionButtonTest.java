package UITests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
import org.testng.Assert;
import java.time.Duration;

public class TitleValidationAndCarAdditionButtonTest {
    private ChromeDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyPageTitleAndAddCarButton() {
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        wait.until(ExpectedConditions.titleIs("Hillel Qauto"));
        Assert.assertEquals(driver.getTitle(), "Hillel Qauto", "The page title does not match the expected!");

        WebElement guestLoginButton = driver.findElement(By.xpath("//button[text()='Guest log in']"));
        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].click();", guestLoginButton);

        WebElement addCarButton = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary')]"));
        wait.until(ExpectedConditions.elementToBeClickable(addCarButton));
        addCarButton.click();
        Assert.assertTrue(addCarButton.isEnabled(), "The 'Add car' button is not clickable.");
    }
}
