package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class TC_010_Logout
{
	
	 WebDriver driver;
     HomePage hp;
     LoginPage lp;
     LogoutPage lg;
     
	@Given("the user is logged into their account")
	public void the_user_is_logged_into_their_account() 
	{
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
    	hp=new HomePage(BaseClass.getDriver());
    	
    	hp.clickMyAccount();
    	hp.clickLogin();
    	
    	lp=new LoginPage(BaseClass.getDriver());
    	String email="nashmask67@gmail.com";
		lp.setEmail(email);
		String password=("nashma@12");
		lp.setPassword(password);
		 lp.clickLogin();
    	
	}

	@When("the user clicks on the {string} link in the account menu")
	public void the_user_clicks_on_the_link_in_the_account_menu(String string)
	{
		BaseClass.getLogger().info("..go to my account......>click logout... ");
		hp.clickMyAccount();
	    hp.clicklogout();
	}

	@SuppressWarnings("deprecation")
	@Then("the user should be redirected to the {string} page")
	public void the_user_should_be_redirected_to_the_page(String string) 
	{
		BaseClass.getLogger().info("...user redirected to logout page.. ");
		lg=new LogoutPage(BaseClass.getDriver());
		String header =lg.getLogoutPageHeader();
		Assert.assertEquals("Redirection to the logout page failed!", "Account Logout", header);
	}

	@SuppressWarnings("deprecation")
	@Then("the user should see the confirmation message")
	public void the_user_should_see_the_confirmation_message() 
	{
		BaseClass.getLogger().info("..user should see the confirmation message... ");
		String expectedMessage = "You have been logged off your account. It is now safe to leave the computer.";
		
		String actualMessage = lg.getConfirmationMessage();
		 Assert.assertEquals("Confirmation message does not match!", expectedMessage, actualMessage);
	}

	 @SuppressWarnings("deprecation")
	@Then("the user click on the {string} button")
	    public void the_user_clicks_on_the_button(String button) {
	        
		 BaseClass.getLogger().info("..user click on the continue button... ");
		 if (button.equalsIgnoreCase("Continue")) {
	            Assert.assertTrue("The Continue button is not displayed!", lg.isContinueButtonDisplayed());
	        }
	       // driver.quit();
	        lg.clickContinueButton();
	    }

}
