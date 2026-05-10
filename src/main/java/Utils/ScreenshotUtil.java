package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverFactory;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        if (DriverFactory.getDriver() == null) {

            System.out.println(
                    "Driver is null. Screenshot skipped.");

            return null;
        }

        File src =
                ((TakesScreenshot)
                        DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.FILE);

        String folderPath =
                System.getProperty("user.dir")
                + "/reports/screenshots/";

        File folder = new File(folderPath);

        if (!folder.exists()) {

            folder.mkdirs();
        }

        String screenshotName =
                testName
                + "_"
                + System.currentTimeMillis()
                + ".png";

        String destination =
                folderPath + screenshotName;

        try {

            FileUtils.copyFile(
                    src,
                    new File(destination));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return destination;
    }
}