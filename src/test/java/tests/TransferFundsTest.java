package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.TestDataUtil;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {

	@Test(enabled = false)
    public void transferFundsTest() {

        HomePage homePage =
                new HomePage();

        homePage.clickRegister();

        RegisterPage registerPage =
                new RegisterPage();

        String username =
                TestDataUtil.getRandomUsername();

        String password = "password";

        registerPage.registerUser(
                "Shilpa",
                "Reddy",
                "Bangalore",
                "Bangalore",
                "KA",
                "560001",
                "9876543210",
                "12345",
                username,
                password);

        LoginPage loginPage =
                new LoginPage();

        Assert.assertTrue(
                loginPage.isLogoutDisplayed(),
                "Registration login failed");

        TransferFundsPage transferPage =
                new TransferFundsPage();

        transferPage.transferFunds("100");
        
        Assert.assertTrue(
        		transferPage.isTransferSuccessful(),
                "Transfer failed");
    }
}