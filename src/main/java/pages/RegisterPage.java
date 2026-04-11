package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import Utils.WaitUtils;

public class RegisterPage {

    WebDriver driver;
    private static final Logger log=LogManager.getLogger(RegisterPage.class);

    public RegisterPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");

    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");

    private By registerBtn = By.xpath("//input[@value='Register']");
    private By successMessage = By.xpath("//p[contains(text(),'Your account was created successfully')]");
    
    private By welcomeUser = By.xpath("//h1[contains(text(),'Welcome')]");
    
	public void registerUser(String firstNameValue, String lastNameValue, String addressValue, String cityValue,
			String stateValue, String zipValue, String phoneValue, String ssnValue, String usernameValue,
			String passwordValue) {
		
		enterFirstName(firstNameValue);
		enterLastName(lastNameValue);
		enterAddress(addressValue);
		enterCity(cityValue);
		enterState(stateValue);
		enterZipCode(zipValue);
		enterPhone(phoneValue);
		enterSSN(ssnValue);

		enterUsername(usernameValue);
		enterPassword(passwordValue);
		enterConfirmPassword(passwordValue);

		clickRegister();
	}

   
    public void enterFirstName(String value) {
    	log.info("Entering First Name: {}", value);
    	WaitUtils.waitForElemetVisible(firstName);
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void enterCity(String value) {
        driver.findElement(city).sendKeys(value);
    }

    public void enterState(String value) {
        driver.findElement(state).sendKeys(value);
    }

    public void enterZipCode(String value) {
        driver.findElement(zipCode).sendKeys(value);
    }

    public void enterPhone(String value) {
        driver.findElement(phone).sendKeys(value);
    }

    public void enterSSN(String value) {
        driver.findElement(ssn).sendKeys(value);
    }

    public void enterUsername(String value) {
        driver.findElement(username).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void enterConfirmPassword(String value) {
        driver.findElement(confirmPassword).sendKeys(value);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }
    public String getSuccessMessage() {
    	log.info("logged in success: {}");
    	WaitUtils.waitForElemetVisible(successMessage);
        return driver.findElement(successMessage).getText();
    }
    
    public String getLoggedInUsername() {
        WaitUtils.waitForElemetVisible(welcomeUser);
        String text = driver.findElement(welcomeUser).getText();
        return text.replace("Welcome ", "").trim();
    }
}