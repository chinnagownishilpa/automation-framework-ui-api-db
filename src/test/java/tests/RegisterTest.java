package tests;

import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.DBUtils;
import Utils.TestDataUtil;
import io.restassured.response.Response;
import pages.HomePage;
import pages.RegisterPage;
import api.CustomerAPI;

@Listeners(listeners.TestListener.class)
public class RegisterTest extends BaseTest{

	private static final Logger log=LogManager.getLogger(RegisterTest.class);
	@Test
	public void registerUser() {
		log.info("Starting Register User Test");
		 HomePage homePage = new HomePage();
		    homePage.clickRegister();
		RegisterPage registerPage=new RegisterPage();
		
		String username=TestDataUtil.getRandomUsername();
		
		
//		registerPage.enterFirstName("Shilpa");
//		registerPage.enterLastName("Reddy");
//		registerPage.enterAddress("Bangalore");
//		registerPage.enterCity("Bangalore");
//		registerPage.enterState("KA");
//		registerPage.enterZipCode("560001");
//		registerPage.enterPhone("9876543210");
//		registerPage.enterSSN("12345");
//
//		registerPage.enterUsername(username);
//		registerPage.enterPassword("password");
//		registerPage.enterConfirmPassword("password");
		
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
	            "password"
	        );

		
		String act_message=registerPage.getSuccessMessage();
		
		Assert.assertTrue(act_message.contains("Your account was created successfully"),"Registration Failed");
		//Assert.assertTrue(false);
	    String actualUsername = registerPage.getLoggedInUsername();
	    Response response = CustomerAPI.getCustomerDetails(actualUsername);
	    //Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println("Response: "+response.asPrettyString());
	    
	    String query="Select * from customers where username='"+username+"'";
//	    ResultSet rs=DBUtils.executeQuery(query);
//	    boolean userExists = false;
//
//	    try {
//	    	if(rs.next()) {
//	    		userExists  = true;
//	    	}
//	    }catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    
//	    Assert.assertTrue(userExists, "User not found in DB");
	    System.out.println("DB validation skipped (no access)");
	}
}
