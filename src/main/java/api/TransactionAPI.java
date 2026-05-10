package api;

import config.ConfigReader;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import builders.RequestSpecBuilderUtil;


public class TransactionAPI {

	private static final String BASE_URL =
	        ConfigReader.get("bankApiBaseUrl");

    public static Response transferFunds(
            Object requestBody) {

        return ApiClient.post(
                BASE_URL,
                "/transactions/transfer",
                requestBody);
    }

    public static Response getTransactionDetails(
            String transactionId) {

        return ApiClient.get(
                BASE_URL,
                "/transactions/" + transactionId);
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