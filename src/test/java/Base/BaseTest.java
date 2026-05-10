package Base;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;
import factory.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        System.out.println("=================================");
        System.out.println("BASE TEST SETUP STARTED");
        System.out.println("=================================");

        try {

            DriverFactory.initDriver("chrome");

            DriverFactory.getDriver()
                         .manage()
                         .window()
                         .maximize();

            DriverFactory.getDriver()
                         .get(ConfigReader.get("baseUrl"));

            DriverFactory.getDriver()
                         .manage()
                         .timeouts()
                         .implicitlyWait(Duration.ofSeconds(10));

            System.out.println("APPLICATION LAUNCHED");
            System.out.println("DRIVER INITIALIZED SUCCESSFULLY");

        } catch (Exception e) {

            System.out.println("ERROR IN BASE TEST SETUP");

            e.printStackTrace();

            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {

        System.out.println("=================================");
        System.out.println("CLOSING DRIVER");
        System.out.println("=================================");

        DriverFactory.quitDriver();
    }
}