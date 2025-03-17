package apitests;

import api.AuthApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutApiTest {

	@Test
	public void verifyLogoutResponse() {
		AuthApi authApi = new AuthApi();
		Response logoutResponse = authApi.logout();

		Assert.assertEquals(logoutResponse.getStatusCode(), 200, "Status code does not match expected value\"");
		Assert.assertEquals(logoutResponse.getBody().asString(), "{\"status\":\"ok\"}", "Response body does not match expected value");
	}
}
