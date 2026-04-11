package factory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	private static final Logger log=LogManager.getLogger(DriverFactory.class);
	
	public static void initDriver(String browser) {
		
		WebDriver driverl;
			
		log.info("Launching browser: " + browser);
			System.out.println("Launching browser: " + browser);
			switch (browser.toLowerCase()) {
			case "chrome": 
				WebDriverManager.chromedriver().setup();
				driverl=new ChromeDriver();
				break;
			case "edge":
				try {
					log.info("Setting up EdgeDriver");
				    WebDriverManager.edgedriver().setup();
				    log.info("Launching Edge browser");
					driverl = new EdgeDriver();
			        log.info("Edge browser launched successfully");

				} catch(Exception e) {
					log.error("edge launch failed", e);
					throw e;
				}
				break;
				
			default :
				throw new RuntimeException("browser not supported");
			} 

			driver.set(driverl);
	} 
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}
	
	
	
}
