package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductAndAddproducttocart;
import pageObjects.WishlistAndComparisionFunctionality;

public class TC_006_WishlistAndComparision 
{
	WebDriver driver;
	HomePage hp;
    LoginPage lp;
    SearchProductAndAddproducttocart sp;
    WishlistAndComparisionFunctionality wc;
    
	@Given("User is on the login page")
	public void user_is_on_the_login_page() 
	{
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
    	hp=new HomePage(BaseClass.getDriver());
    	
    	hp.clickMyAccount();
    	hp.clickLogin();
	}

	@When("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials()
	{
		BaseClass.getLogger().info("..enter login details... ");
		lp=new LoginPage(BaseClass.getDriver());
       String email="nashmask67@gmail.com";
        lp.setEmail(email);
        String pwd ="nashma@12";
        lp.setPassword(pwd);
        lp.clickLogin();
	}

	@Then("User is redirected to the homepage")
	public void user_is_redirected_to_the_homepage() 
	{
		BaseClass.getLogger().info("...redirected to home page.. ");
		 driver = BaseClass.getDriver();
		 driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	}

	@When("User browses products and adds {string} to the wishlist")
	public void user_browses_products_and_adds_to_the_wishlist(String string)
	{
		BaseClass.getLogger().info("...Search product.. ");
		sp=new SearchProductAndAddproducttocart(BaseClass.getDriver()) ;
		sp.isProductExist(string);
		sp.selectProduct(string);
		wc= new WishlistAndComparisionFunctionality(BaseClass.getDriver());
		wc.addToWishlist();
	}

	@Then("Product {string} is successfully added to the wishlist with a success message")
	public void product_is_successfully_added_to_the_wishlist_with_a_success_message(String string) 
	{
		
	    wc.getSuccessMessage();
	}

	@When("User navigates to the wishlist page")
	public void user_navigates_to_the_wishlist_page() 
	{
		BaseClass.getLogger().info("...navigate to wishlist page.. ");
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/wishlist");
	}

	@Then("Product {string} is displayed in the wishlist")
	public void product_is_displayed_in_the_wishlist(String string) 
	{
	    wc.isProductInWishlist(string);
	}

	@When("User adds the following products to the comparison list:")
	public void user_adds_the_following_products_to_the_comparison_list(io.cucumber.datatable.DataTable dataTable) 
	{
		BaseClass.getLogger().info("..user add more products... ");
		for (String product : dataTable.asList()) {
            driver.get("https://tutorialsninja.com/demo/index.php?route=product/search&search=" + product);
            wc.clickcomparison();
		}
	}

	@Then("Products are successfully added to the comparison list with a success message")
	public void products_are_successfully_added_to_the_comparison_list_with_a_success_message() 
	{
		BaseClass.getLogger().info("..comparision of products... ");
		 String message =wc.getComparisonSuccessMessage();
		 assertTrue(message.contains("Success"));
		
	   	}

	@When("User navigates to the comparison page")
	public void user_navigates_to_the_comparison_page()
	{
		 driver.get("https://tutorialsninja.com/demo/index.php?route=product/compare");
	}

	@Then("Products are displayed side-by-side with key attributes")
	public void products_are_displayed_side_by_side_with_key_attributes() throws InterruptedException 
	{
		assertTrue(wc.isProductDisplayedInComparison("iPhone"));
		Thread.sleep(2000);
        assertTrue(wc.isProductDisplayedInComparison("MacBook"));
	}

	@When("User navigates to the wishlist page and removes product {string}")
	public void user_navigates_to_the_wishlist_page_and_removes_product(String string) 
	{
		BaseClass.getLogger().info("..navigate to wishlist page... ");
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/wishlist");
		wc.removeProduct();
	    	}

	@Then("Product {string} is removed from the wishlist with a success message")
	public void product_is_removed_from_the_wishlist_with_a_success_message(String string) 
	{
		BaseClass.getLogger().info("..product is removed from the wishlist... ");
		String message = wc.getModifyMessage();
        assertTrue(message.contains("Success")); 
	}

	

	@Then("The wishlist page displays a message indicating it is empty")
	public void the_wishlist_page_displays_a_message_indicating_it_is_empty() 
	{
		BaseClass.getLogger().info("..wishlist is empty... ");
		String message = wc.getEmptyWishlistMessage();
        assertTrue(message.contains("Your wish list is empty."));
	}



}
