package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.BookingDates;
import models.BookingRequest;

public class CreateBookingTest {

    @Test
    public void createBookingTest() {

        BookingDates dates =
                new BookingDates(
                        "2024-05-01",
                        "2024-05-10");

        BookingRequest request =
                new BookingRequest(
                        "Shilpa",
                        "Reddy",
                        2000,
                        true,
                        dates,
                        "Breakfast");

        Response response =
                BookingAPI.createBooking(request);

        response.then().statusCode(200);

        int bookingId =
                response.jsonPath()
                        .getInt("bookingid");

        System.out.println(
                "BOOKING ID: " + bookingId);

        Assert.assertTrue(bookingId > 0);
    }
}