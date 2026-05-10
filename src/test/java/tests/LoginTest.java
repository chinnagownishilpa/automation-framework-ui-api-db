package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.TestDataUtil;
import dataproviders.LoginDataProvider;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;


public class LoginTest extends BaseTest {
	
	@Test(dataProvider = "loginData",
		      dataProviderClass = LoginDataProvider.class,
			    retryAnalyzer = retry.RetryAnalyzer.class
)
		public void existingUserLoginTest(
		        String username,
		        String password,
		        String validUser) {

		    LoginPage loginPage =
		            new LoginPage();

		    loginPage.login(username, password);
		    
		   //Assert.assertTrue(false);
		    
		    if (validUser.equalsIgnoreCase("TRUE")) {

		        Assert.assertTrue(
		                loginPage.isLogoutDisplayed(),
		                "Valid login failed");

		        System.out.println("VALID LOGIN VERIFIED");

		    } else {

		    	Assert.assertFalse(
		    	        loginPage.isLogoutDisplayed(),
		    	        "Invalid login validation failed");
		    }
		}

    @Test
    public void registrationAndLoginFlowTest() {

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

        loginPage.clickLogout();

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Logout failed");
    }
	
	

}
