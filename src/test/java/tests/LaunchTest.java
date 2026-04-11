package tests;

import org.testng.annotations.Test;

import Base.BaseTest;

public class LaunchTest extends BaseTest{
	
	@Test
	public void openapplication() {
		String title=factory.DriverFactory.getDriver().getTitle();
		System.out.println("Page title is: "+title);
	}
}	

