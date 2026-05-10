package api;

import config.ConfigReader;
import io.restassured.response.Response;

public class CustomerAPI {

	private static final String BASE_URL =
	        ConfigReader.get("bankApiBaseUrl");

    public static Response getCustomerDetails(String customerId) {

        return ApiClient.get(
                BASE_URL,
                "/customers/" + customerId);
    }
}