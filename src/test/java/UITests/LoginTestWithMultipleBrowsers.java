package UITests;

import com.hillel.BrowserData;
import com.hillel.BrowserFactory;
import com.hillel.page_objects.HomePage;
import com.hillel.waitelement.WaitElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestWithMultipleBrowsers {
	private WebDriver driver;
	private String browser;

	@Factory(dataProviderClass = BrowserData.class, dataProvider = "browsers")
	public LoginTestWithMultipleBrowsers(String browser) {
		this.browser = browser;
	}

	@BeforeMethod
	public void setUp() {
		BrowserFactory.createDriver(browser);
		driver = BrowserFactory.getDriver();
	}

	@Test()
	public void testInvalidLogin() {
		HomePage homePage = new HomePage()
				.open()
				.clickSignInButton()
				.setEmail("test@hillel.ua")
				.setPassword("1111")
				.clickLoginButton();

		WaitElement.waitForTextToBePresent(homePage.getErrorMessageLocator(), "Wrong email or password", 10);

		String errorMessage = homePage.getErrorMessage();

		Assert.assertEquals(errorMessage, "Wrong email or password");
	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
}
