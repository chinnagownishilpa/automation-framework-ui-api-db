package tests;

import org.testng.annotations.Test;

import api.ApiClient;
import io.restassured.response.Response;

public class BookingFlowTest {
	String baseurl="https://restful-booker.herokuapp.com";
	String body="{\r\n"
			+ "  \"firstname\": \"shilpa\",\r\n"
			+ "  \"lastname\": \"Test\",\r\n"
			+ "  \"totalprice\": 1000,\r\n"
			+ "  \"depositpaid\": true,\r\n"
			+ "  \"bookingdates\": {\r\n"
			+ "    \"checkin\": \"2024-01-01\",\r\n"
			+ "    \"checkout\": \"2024-01-05\"\r\n"
			+ "  },\r\n"
			+ "  \"additionalneeds\": \"Breakfast\"\r\n"
			+ "}";
	@Test
	public void endToEndBooking() {
		Response createRes = ApiClient.createBooking(baseurl, body);
			createRes.then().statusCode(200);
			int bookingId = createRes.jsonPath().getInt("bookingid");	
		
		
	String authbody="{ \"username\": \"admin\", \"password\": \"password123\" }";
			
		Response tokenRes = ApiClient.generateToken(baseurl, authbody);
			String token = tokenRes.jsonPath().getString("token");
			
		ApiClient.deleteBooking(baseurl, bookingId, token)
			.then().statusCode(201);
	}

}
