package UITests;

import com.hillel.TestSetup;
import com.hillel.LoginData;
import com.hillel.page_objects.HomePage;
import com.hillel.waitelement.WaitElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestSetup {

    @Test(dataProviderClass = LoginData.class, dataProvider = "invalidCredentials")
    public void verifyErrorMessageForInvalidEmailOrPassword(String email, String password) {
        HomePage homePage = new HomePage()
                .open()
                .clickSignInButton()
                .setEmail(email)
                .setPassword(password)
                .clickLoginButton();

        WaitElement.waitForTextToBePresent(homePage.getErrorMessageLocator(), "Wrong email or password", 10);

        String errorMessage = homePage.getErrorMessage();

        Assert.assertEquals(errorMessage, "Wrong email or password");
    }
}


