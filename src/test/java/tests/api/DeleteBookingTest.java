package tests.api;

import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.AuthRequest;
import models.BookingDates;
import models.BookingRequest;

public class DeleteBookingTest {

    @Test
    public void deleteBookingTest() {

        BookingDates dates =
                new BookingDates(
                        "2024-01-01",
                        "2024-01-05");

        BookingRequest request =
                new BookingRequest(
                        "Shilpa",
                        "Delete",
                        1200,
                        true,
                        dates,
                        "Lunch");

        Response createResponse =
                BookingAPI.createBooking(request);

        int bookingId =
                createResponse.jsonPath()
                        .getInt("bookingid");

        AuthRequest auth =
                new AuthRequest(
                        "admin",
                        "password123");

        String token =
                BookingAPI.generateToken(auth)
                        .jsonPath()
                        .getString("token");

        BookingAPI.deleteBooking(
                bookingId,
                token)
                .then()
                .statusCode(201);
    }
}