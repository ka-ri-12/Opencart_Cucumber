package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends BasePage
{
public ContactusPage(WebDriver driver)
{
	super(driver);
}


@FindBy(xpath="//i[@class='fa fa-phone']")
WebElement btncontactus;

@FindBy(xpath="//input[@id='input-name']")
WebElement nameField;

@FindBy(xpath="//input[@id='input-email']")
WebElement emailField;

@FindBy(xpath="//textarea[@id='input-enquiry']")
WebElement messageField;

@FindBy(xpath="//input[@value='Submit']")
WebElement submitButton;

@FindBy(xpath="//a[normalize-space()='Continue']")
static
WebElement continueButton;


public void enterName(String name) 
{
	nameField.clear();
    nameField.sendKeys(name);
}

public void enterEmail(String email) {
    emailField.clear();
	emailField.sendKeys(email);
}

public void enterMessage(String message) 
{
	messageField.clear();
    messageField.sendKeys(message);
}

public void clickSubmitButton() {
    submitButton.click();
}

public static boolean isContinueButtonDisplayed() {
    try {
		return continueButton.isDisplayed();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}

public void clickContinueButton() {
    continueButton.click();
}

}
