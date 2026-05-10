package api;

import static io.restassured.RestAssured.given;

import builders.RequestSpecBuilderUtil;
import config.ConfigReader;
import io.restassured.response.Response;

public class AccountAPI {

	private static final String BASE_URL =
	        ConfigReader.get("bankApiBaseUrl");

    public static Response createAccount(
            Object requestBody) {

        return ApiClient.post(
                BASE_URL,
                "/accounts",
                requestBody);
    }

    public static Response getAccountDetails(
            String accountId) {

        return ApiClient.get(
                BASE_URL,
                "/accounts/" + accountId);
    }

    public static Response updateAccount(
            String accountId,
            Object requestBody) {

        return ApiClient.put(
                BASE_URL,
                "/accounts/" + accountId,
                requestBody);
    }

    public static Response delete(
            String baseUrl,
            String endpoint) {

        return given()
                .spec(
                        RequestSpecBuilderUtil
                                .getRequestSpec(baseUrl))
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}