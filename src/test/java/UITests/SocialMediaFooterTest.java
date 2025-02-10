package UITests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaFooterTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifySocialMediaLinks() {
        List<WebElement> socialMediaIcons = driver.findElements(By.cssSelector("span.socials_icon.icon.icon-facebook, span.socials_icon.icon.icon-telegram, span.socials_icon.icon.icon-youtube, span.socials_icon.icon.icon-instagram, span.socials_icon.icon.icon-linkedin"));
        Assert.assertEquals(socialMediaIcons.size(), 5, "Social network block doesn’t contain 5 items");

        List<String> expectedUrls = List.of(
                "https://www.facebook.com/Hillel.IT.School",
                "https://t.me/ithillel_kyiv",
                "https://www.youtube.com/user/HillelITSchool",
                "https://www.instagram.com/hillel_itschool/",
                "https://www.linkedin.com"
        );

        for (int i = 0; i < socialMediaIcons.size(); i++) {
            String originalTab = driver.getWindowHandle();
            socialMediaIcons.get(i).click();

            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            tabs.remove(originalTab);

            if (tabs.isEmpty()) {
                Assert.fail("New tab did not open after clicking on social media icon.");
            } else {
                driver.switchTo().window(tabs.get(0));
            }

            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.contains("youtube.com")) {
                try {
                    WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Accept all' and contains(@class, 'VfPpkd-LgbsSe')]")));
                    acceptCookies.click();
                    currentUrl = driver.getCurrentUrl();
                } catch (TimeoutException ignored) {
                }
            }

            Assert.assertTrue(currentUrl.contains(expectedUrls.get(i)), "Incorrect URL of Social network: " + currentUrl);

            driver.close();
            driver.switchTo().window(originalTab);
        }
    }
}

