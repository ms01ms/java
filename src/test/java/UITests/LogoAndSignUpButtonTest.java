package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LogoAndSignUpButtonTest {

    private static WebDriver driver;

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
    public void verifyLogoDisplayed() {
        WebElement logo = driver.findElement(By.xpath("//app-header//div[1]/a"));
        assertTrue(logo.isDisplayed(), "Logo does not displayed");
        Reporter.log("Logo displayed", true);
    }

    @Test
    public void verifySignupButtonColor() {
        WebElement signUpButton = driver.findElement(By.xpath("//app-home//div[1]//button"));
        String backgroundColor = signUpButton.getCssValue("background-color");
        String expectedColor = "rgba(2, 117, 216, 1)";
        assertEquals(backgroundColor, expectedColor, "Background color of Sign up button is incorrect");
        Reporter.log("Background color of Sign up button is correct", true);
    }
}
