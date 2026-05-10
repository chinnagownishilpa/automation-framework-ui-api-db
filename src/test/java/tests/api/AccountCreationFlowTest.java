package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.AccountAPI;
import io.restassured.response.Response;
import models.AccountRequest;

public class AccountCreationFlowTest {

	@Test(enabled = false)
    public void accountCreationFlowTest() {

        AccountRequest request =
                new AccountRequest(
                        "CUST001",
                        "Savings",
                        5000);

        Response createResponse =
                AccountAPI.createAccount(request);

        createResponse.then().statusCode(200);

        String accountId =
                createResponse.jsonPath()
                        .getString("accountId");

        System.out.println(
                "ACCOUNT ID: " + accountId);

        Response detailsResponse =
                AccountAPI.getAccountDetails(accountId);

        detailsResponse.then().statusCode(200);

        String accountType =
                detailsResponse.jsonPath()
                        .getString("accountType");

        Assert.assertEquals(
                accountType,
                "Savings");

        AccountRequest updatedRequest =
                new AccountRequest(
                        "CUST001",
                        "Savings",
                        10000);

        Response updateResponse =
                AccountAPI.updateAccount(
                        accountId,
                        updatedRequest);

        updateResponse.then().statusCode(200);

        Response updatedDetails =
                AccountAPI.getAccountDetails(accountId);

        double updatedBalance =
                updatedDetails.jsonPath()
                        .getDouble("balance");

        Assert.assertEquals(
                updatedBalance,
                10000);
    }
}