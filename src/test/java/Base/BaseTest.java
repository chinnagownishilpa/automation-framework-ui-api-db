package Base;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import config.ConfigReader;
import factory.DriverFactory;

public class BaseTest {

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		if(browser == null) {
			browser = ConfigReader.get("browser");
		}
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
