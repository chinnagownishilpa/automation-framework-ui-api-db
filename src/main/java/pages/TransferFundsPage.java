package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.WaitUtils;
import factory.DriverFactory;

public class TransferFundsPage {

    WebDriver driver;

    public TransferFundsPage() {

        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By transferFundsLink =
            By.linkText("Transfer Funds");

    private By amount =
            By.id("amount");

    private By transferBtn =
            By.xpath("//input[@value='Transfer']");

    private By successMessage =
            By.xpath("//*[contains(text(),'Transfer Complete')]");

    public void clickTransferFunds() {

        WaitUtils.waitForElemetVisible(transferFundsLink);

        driver.findElement(transferFundsLink).click();
    }

    public void enterAmount(String value) {

        WaitUtils.waitForElemetVisible(amount);

        driver.findElement(amount).sendKeys(value);
    }

    public void clickTransferButton() {

        driver.findElement(transferBtn).click();
    }

    public void transferFunds(String value) {

        clickTransferFunds();
        enterAmount(value);
        clickTransferButton();
    }

    public boolean isTransferSuccessful() {

        try {

            return driver.getCurrentUrl()
                    .contains("transfer");

        } catch (Exception e) {

            return false;
        }
    }
}