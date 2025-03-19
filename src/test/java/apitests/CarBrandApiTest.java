package apitests;

import api.CarBrandApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CarBrandApiTest {
	@Test
	public void verifyCarBrandResponse() {
		CarBrandApi carBrandApi = new CarBrandApi();
		Response carBrandsResponse = carBrandApi.getCarBrands();

		Assert.assertEquals(carBrandsResponse.getStatusCode(), 200, "Status code does not match expected value");

		JsonPath jsonPath = carBrandsResponse.jsonPath();

		Assert.assertEquals(jsonPath.getInt("data[0].id"), 1, "id does not match expected value");
		Assert.assertEquals(jsonPath.getString("data[0].title"), "Audi", "title does not match expected value");
	}

	@Test
	public void verifyCarBrandResponseWithHTTP() throws InterruptedException, IOException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://qauto.forstudy.space/api/cars/brands"))
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		Assert.assertEquals(response.statusCode(), 200, "Status code does not match expected value");

		boolean containsAudi = response.body().matches(".*\"id\":\\s*1.*\"title\":\\s*\"Audi\".*");

		Assert.assertTrue(containsAudi, "Response body does not contain 'id': 1 and 'title': 'Audi'");
	}
}

