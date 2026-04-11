package api;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CustomerAPI {

	public static Response getCustomerDetails(String username) {
		return RestAssured
				.given()
				.baseUri(ConfigReader.get("apiBaseUrl"))
				.when()
				.get("/customers/"+username)
				.then()
				.extract()
				.response();
		
	}
}
