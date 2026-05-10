package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.AuthRequest;
import models.BookingDates;
import models.BookingRequest;

public class UpdateBookingTest {

    @Test
    public void updateBookingTest() {

        // CREATE BOOKING

        BookingDates oldDates =
                new BookingDates(
                        "2024-01-01",
                        "2024-01-05");

        BookingRequest oldRequest =
                new BookingRequest(
                        "Shilpa",
                        "Old",
                        1000,
                        true,
                        oldDates,
                        "Breakfast");

        Response createResponse =
                BookingAPI.createBooking(oldRequest);

        createResponse.then().statusCode(200);

        int bookingId =
                createResponse.jsonPath()
                        .getInt("bookingid");

        System.out.println(
                "BOOKING ID: " + bookingId);

        // GENERATE TOKEN

        AuthRequest authRequest =
                new AuthRequest(
                        "admin",
                        "password123");

        Response tokenResponse =
                BookingAPI.generateToken(authRequest);

        tokenResponse.then().statusCode(200);

        String token =
                tokenResponse.jsonPath()
                        .getString("token");

        System.out.println(
                "TOKEN: " + token);

        // UPDATED DATA

        BookingDates newDates =
                new BookingDates(
                        "2024-06-01",
                        "2024-06-10");

        BookingRequest updatedRequest =
                new BookingRequest(
                        "Updated",
                        "User",
                        5000,
                        false,
                        newDates,
                        "Lunch");

        // UPDATE BOOKING

        Response updateResponse =
                BookingAPI.updateBooking(
                        bookingId,
                        updatedRequest,
                        token);

        updateResponse.prettyPrint();

        updateResponse.then().statusCode(200);

        // VALIDATIONS

        String firstName =
                updateResponse.jsonPath()
                        .getString("firstname");

        int totalPrice =
                updateResponse.jsonPath()
                        .getInt("totalprice");

        Assert.assertEquals(
                firstName,
                "Updated");

        Assert.assertEquals(
                totalPrice,
                5000);

        System.out.println(
                "BOOKING UPDATED SUCCESSFULLY");
    }
}