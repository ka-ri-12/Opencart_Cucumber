package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.ContactusPage;
import pageObjects.HomePage;

public class TC_009_ContactUsForm 
{
WebDriver driver;
HomePage hp;
ContactusPage cp;

@Given("the user is on the {string} page")
public void the_user_is_on_the_page(String string) 
{
	BaseClass.getLogger().info("..user click on contact us... ");
	hp=new HomePage(BaseClass.getDriver());
	hp.clickcontactus();
}

@When("the user fills out the form with valid data")
public void the_user_fills_out_the_form_with_valid_data()
{
	BaseClass.getLogger().info("..user fill the details in contact us form... ");
   cp= new ContactusPage(BaseClass.getDriver());
   cp.enterName("nashma");
   cp.enterEmail("nashmask67@gmail.com");
   cp.enterMessage("I would like more details about your products.");
}

@When("the user clicks the {string} button")
public void the_user_clicks_the_button(String string) 
{
	BaseClass.getLogger().info("..user click the submit button... ");
    cp.clickSubmitButton();
}

@SuppressWarnings("deprecation")
@Then("the {string} button should be displayed")
public void the_button_should_be_displayed(String button) 
{
	BaseClass.getLogger().info("..user check the continue button is displayed or not... ");
	 if (button.equalsIgnoreCase("Continue")) {
         Assert.assertTrue(ContactusPage.isContinueButtonDisplayed());
         
         cp.clickContinueButton();
    }

}

}
