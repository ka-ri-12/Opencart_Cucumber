package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.orderHistoryPage;

@SuppressWarnings("deprecation")
public class TC_008_OrderHistorySteps 
{
	
	 WebDriver driver;
     HomePage hp;
     LoginPage lp;
     orderHistoryPage ohp;
	
	@Given("the user is logged into their account on website")
	public void the_user_is_logged_into_their_account_on_website()
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

	@When("the user navigates to the Order History page through the My Account menu")
	public void the_user_navigates_to_the_order_history_page_through_the_my_account_menu() 
	{
		BaseClass.getLogger().info("...click on my account ....>go to order history... ");
		hp.clickMyAccount();
		ohp= new orderHistoryPage(BaseClass.getDriver());
		ohp.goToOrderHistory();
		
	    	}

	@SuppressWarnings("deprecation")
	@Then("the user should see a list of their past orders, including Order ID, Status, and Total Cost")
	public void the_user_should_see_a_list_of_their_past_orders_including_order_id_status_and_total_cost() 
	{
		BaseClass.getLogger().info("...user list of past orders... ");
		System.out.println("Number of orders found: " + ohp.getOrders().size());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ohp.getOrders()));
		Assert.assertTrue(ohp.getOrders().size() > 0);

		
	}

	@When("the user clicks on the View button for a specific order")
	public void the_user_clicks_on_the_view_button_for_a_specific_order() 
	{
		BaseClass.getLogger().info("...user open the specific order.. ");
	    ohp.clickViewButton(1);
	}

	
	@SuppressWarnings("deprecation")
	@Then("the user should see detailed information about the selected order")
	public void the_user_should_see_detailed_information_about_the_selected_order() 
	{
		System.out.println("Waiting for order details to load...");
		
		BaseClass.getLogger().info("..user should see details of the order... ");
		ohp.isOrderDetailsDisplayed();
		
		
		 // Fetch order details
        List<String> productNames = ohp.getProductNames();
        List<String> models = ohp.getModels();
        List<String> quantities = ohp.getQuantities();
        List<String> prices = ohp.getPrices();

        // Print details for debugging
        System.out.println("Product Names: " + productNames);
        System.out.println("Models: " + models);
        System.out.println("Quantities: " + quantities);
        System.out.println("Prices: " + prices);

        // Example assertions to verify that the lists are not empty
        Assert.assertFalse("Product names are empty!", productNames.isEmpty());
        Assert.assertFalse("Models are empty!", models.isEmpty());
        Assert.assertFalse("Quantities are empty!", quantities.isEmpty());
        Assert.assertFalse("Prices are empty!", prices.isEmpty());

        
    }
			}




