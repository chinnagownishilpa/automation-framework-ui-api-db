package tests.api;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.BookingDates;
import models.BookingRequest;

public class BookingSchemaValidationTest {

    @Test
    public void validateBookingSchema() {

        BookingDates dates =
                new BookingDates(
                        "2024-01-01",
                        "2024-01-05");

        BookingRequest request =
                new BookingRequest(
                        "Schema",
                        "Test",
                        1000,
                        true,
                        dates,
                        "Breakfast");

        Response response =
                BookingAPI.createBooking(request);

        response.then()
                .statusCode(200)
                .assertThat()
                .body(
                        matchesJsonSchemaInClasspath(
                                "schemas/booking-schema.json"));

        System.out.println(
                "SCHEMA VALIDATION PASSED");
    }
}