package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;

public class WaitUtils {
	
	public static WebDriverWait getWait() {
		return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));		
	}
	public static void waitForElemetVisible(By loc) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
	public static void waitForelementClickable(By loc) {
		getWait().until(ExpectedConditions.elementToBeClickable(loc));
	}

}
