package api;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthApi {
	private static final String LOGOUT_API_URL = "https://qauto.forstudy.space/api/auth/logout";

	public Response logout() {
		return RestAssured
				.given()
				.log()
				.all()
				.when()
				.get(LOGOUT_API_URL);
	}
}



