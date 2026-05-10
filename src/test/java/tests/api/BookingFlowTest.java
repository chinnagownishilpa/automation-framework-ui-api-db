package tests.api;

import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.AuthRequest;
import models.BookingDates;
import models.BookingRequest;

public class BookingFlowTest {

    @Test
    public void endToEndBooking() {

        BookingDates dates =
                new BookingDates("2024-01-01", "2024-01-05");

        BookingRequest bookingRequest =
                new BookingRequest(
                        "Shilpa",
                        "Test",
                        1000,
                        true,
                        dates,
                        "Breakfast");

        Response createRes =
                BookingAPI.createBooking(bookingRequest);

        createRes.then().statusCode(200);

        int bookingId =
                createRes.jsonPath().getInt("bookingid");

        AuthRequest authRequest =
                new AuthRequest("admin", "password123");

        Response tokenRes =
                BookingAPI.generateToken(authRequest);

        String token =
                tokenRes.jsonPath().getString("token");

        BookingAPI.deleteBooking(bookingId, token)
                .then()
                .statusCode(201);
    }
}