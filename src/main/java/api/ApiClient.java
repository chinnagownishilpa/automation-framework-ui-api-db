package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class ApiClient {

	public static Response createBooking(String baseUrl, String body) {
		return given()
				.baseUri(baseUrl)
				.header("Content-Type", "application/json")
				.body(body)
			.when()
				.post("/booking");
	}
	
	public static Response generateToken(String baseUrl, String authBody) {
		return given()
				.baseUri(baseUrl)
				.header("Content-Type", "application/json")
				.body(authBody)
			.when()
				.post("/auth");
	}
	
	public static Response deleteBooking(String baseUrl, int bookingId, String token) {
		return given()
				.baseUri(baseUrl)
				.header("Cookie","token=" +token)
			.when()
				.delete("/booking/"+bookingId);	
	}
}
