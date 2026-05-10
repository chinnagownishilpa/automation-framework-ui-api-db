package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.WaitUtils;
import factory.DriverFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By username =
            By.name("username");

    private By password =
            By.name("password");

    private By loginBtn =
            By.xpath("//input[@value='Log In']");

    private By logoutLink =
            By.linkText("Log Out");
    private By errorMessage =
            By.xpath("//*[contains(text(),'could not be verified')]");
    
    

    public void enterUsername(String user) {

        WaitUtils.waitForElemetVisible(username);
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {

        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass) {

        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public void clickLogout() {

        WaitUtils.waitForElemetVisible(logoutLink);
        driver.findElement(logoutLink).click();
    }

    // Validations
    public boolean isLogoutDisplayed() {

        try {

            return driver.findElement(
                    By.linkText("Log Out"))
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isLoginButtonDisplayed() {

        WaitUtils.waitForElemetVisible(loginBtn);

        return driver.findElement(loginBtn).isDisplayed();
    }
    public boolean isLoginErrorDisplayed() {

        return driver.findElements(errorMessage)
                .size() > 0;
    }
}