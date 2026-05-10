package api;

import config.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.BookingRequest;
import static io.restassured.RestAssured.given;

public class BookingAPI {

	private static final String BASE_URL =
	        ConfigReader.get("bookingApiBaseUrl");

    public static Response createBooking(
            Object requestBody) {

        return ApiClient.post(
                BASE_URL,
                "/booking",
                requestBody);
    }

    public static Response generateToken(
            Object requestBody) {

        return ApiClient.post(
                BASE_URL,
                "/auth",
                requestBody);
    }

    public static Response getBooking(
            int bookingId) {

        return ApiClient.get(
                BASE_URL,
                "/booking/" + bookingId);
    }

    public static Response updateBooking(
            int bookingId,
            BookingRequest body,
            String token) {

        return 
               given() .baseUri(BASE_URL)
                .header("Cookie", "token=" + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/booking/" + bookingId)
                .then()
                .extract()
                .response();
    } 

    public static Response deleteBooking(
            int bookingId,
            String token) {

        return ApiClient.deleteWithToken(
                BASE_URL,
                "/booking/" + bookingId,
                token);
    }
}