package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CarBrandApi {
	private static final String CAR_BRANDS_API_URL = "https://qauto.forstudy.space/api/cars/brands";

	public Response getCarBrands() {
		return RestAssured
				.given()
				.log()
				.all()
				.when()
				.get(CAR_BRANDS_API_URL);
	}
}

