package Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverFactory;

public class ScreenshotUtil {
	
	public static String captureScreenshot(String testName) {
		
		TakesScreenshot ts=(TakesScreenshot) DriverFactory.getDriver();
		File src=ts.getScreenshotAs(OutputType.FILE);
			
		String path="reports/screenshots/" + testName + ".png";
		try {
         
			FileUtils.copyFile(src,	new File(path));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}

}
