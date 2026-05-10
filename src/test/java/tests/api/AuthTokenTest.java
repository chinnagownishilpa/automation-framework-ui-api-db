package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.BookingAPI;
import io.restassured.response.Response;
import models.AuthRequest;

public class AuthTokenTest {

    @Test
    public void generateAuthTokenTest() {

        AuthRequest request =
                new AuthRequest(
                        "admin",
                        "password123");

        Response response =
                BookingAPI.generateToken(request);

        response.then().statusCode(200);

        String token =
                response.jsonPath()
                        .getString("token");

        System.out.println("TOKEN: " + token);

        Assert.assertNotNull(token);
    }
}