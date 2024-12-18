package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage
{
public LogoutPage(WebDriver driver)
{
	super(driver);
}


@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement logoutLink;

@FindBy(xpath="//h1[normalize-space()='Account Logout']")
WebElement logoutPageHeader;

@FindBy(xpath="//p[contains(text(),'You have been logged off your account. It is now s')]")
WebElement confirmationMessage;

@FindBy(xpath="//a[normalize-space()='Continue']")
WebElement continueButton;


public void clickLogoutLink() {
    logoutLink.click();
}

public String getLogoutPageHeader() {
    return logoutPageHeader.getText();
}

public String getConfirmationMessage() {
    return confirmationMessage.getText();
}

public boolean isContinueButtonDisplayed() {
    return continueButton.isDisplayed();
}

public void clickContinueButton() {
    continueButton.click();
}



}
