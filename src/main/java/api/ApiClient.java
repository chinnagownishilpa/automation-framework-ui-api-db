package api;

import static io.restassured.RestAssured.given;

import builders.RequestSpecBuilderUtil;
import io.restassured.response.Response;

public class ApiClient {

    public static Response get(
            String baseUrl,
            String endpoint) {

        return given()
                .spec(
                        RequestSpecBuilderUtil
                                .getRequestSpec(baseUrl))
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response post(
            String baseUrl,
            String endpoint,
            Object body) {

        return given()
                .spec(
                        RequestSpecBuilderUtil
                                .getRequestSpec(baseUrl))
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response put(
            String baseUrl,
            String endpoint,
            Object body) {

        return given()
                .spec(
                        RequestSpecBuilderUtil
                                .getRequestSpec(baseUrl))
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response putWithToken(
            String baseUrl,
            String endpoint,
            Object body,
            String token) {

        return given()
                .spec(
                        RequestSpecBuilderUtil
                                .getRequestSpec(baseUrl))
                .header("Cookie", "token=" + token)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response deleteWithToken(
            String baseUrl,
            String endpoint,
            String token) {

        return given()
                .spec(
                        RequestSpecBuilderUtil
                                .getRequestSpec(baseUrl))
                .header("Cookie", "token=" + token)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}