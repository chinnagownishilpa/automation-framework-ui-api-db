package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.BookingDates;
import models.BookingRequest;

public class GetBookingTest {

    @Test
    public void getBookingDetailsTest() {

        BookingDates dates =
                new BookingDates(
                        "2024-05-01",
                        "2024-05-05");

        BookingRequest request =
                new BookingRequest(
                        "Shilpa",
                        "Test",
                        1500,
                        true,
                        dates,
                        "Lunch");

        Response createResponse =
                BookingAPI.createBooking(request);

        int bookingId =
                createResponse.jsonPath()
                        .getInt("bookingid");

        Response getResponse =
                BookingAPI.getBooking(bookingId);

        getResponse.then().statusCode(200);

        String firstname =
                getResponse.jsonPath()
                        .getString("firstname");

        Assert.assertEquals(
                firstname,
                "Shilpa");
    }
}