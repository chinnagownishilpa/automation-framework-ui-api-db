package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;

public class HomePage {

    WebDriver driver;
    private static final Logger log=LogManager.getLogger(HomePage.class);
    private By registerLink = By.linkText("Register");

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    public void clickRegister() {
    	log.info("clicking on Registration link");
        driver.findElement(registerLink).click();
    }
}