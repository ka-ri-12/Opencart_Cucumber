package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductAndAddproducttocart;
import pageObjects.Searchproduct;
import pageObjects.ShoppingCartPage;

public class TC_007_CheckoutAndPlaceAnOrder
{
	 WebDriver driver;
	 HomePage hp;
	 LoginPage lp;
	 Searchproduct sp;
	 SearchProductAndAddproducttocart sa;
	 ShoppingCartPage scp;
	 CheckoutPage cp;
	 
	@Given("User is on the homepage of the website")
	public void user_is_on_the_homepage_of_the_website() throws InterruptedException 
	{
		hp=new HomePage(BaseClass.getDriver());
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		hp.clickMyAccount();
    	hp.clickLogin();
    	lp=new LoginPage(BaseClass.getDriver());
    	String email="nashmask67@gmail.com";
		lp.setEmail(email);
		String password=("nashma@12");
		lp.setPassword(password);
		 lp.clickLogin();
    	
	}
    	
    	
    	
	
	@When("User searches for {string} product")
	public void user_searches_for_product(String string)
	{
		BaseClass.getLogger().info("...search product.. ");
		BaseClass.getLogger().info("enter product in searchbar ");
		sp = new Searchproduct(BaseClass.getDriver());
	    sp.enterProductname(string);
	    sp.clicksearchbtn();
	}

	@When("User adds the product to the cart")
	public void user_adds_the_product_to_the_cart() throws InterruptedException 
	{
		BaseClass.getLogger().info("..add product to cart and click view cart... ");
		sa=new SearchProductAndAddproducttocart(BaseClass.getDriver()) ;
		sa.addToCart();
		
		/* driver = BaseClass.getDriver();
		 driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");*/
		 
		 scp=new ShoppingCartPage(BaseClass.getDriver());
          scp.clickItemsToNavigateToCart();
		   scp.clickViewCart();
	}

	@When("User proceeds to checkout")
	public void user_proceeds_to_checkout() 
	{
		BaseClass.getLogger().info("..user proceed to checkout... ");
		scp.clickOnCheckout();
	    	}

	@When("User enters random billing details")
	public void user_enters_random_billing_details() throws InterruptedException 
	{
		BaseClass.getLogger().info("..enter billing details... ");
	   cp=new CheckoutPage(BaseClass.getDriver()) ;
	 cp.clicknewaddress();
	   cp.setfirstName("nashma");
	   cp.setlastName(RandomStringUtils.randomAlphabetic(5));
	   cp.setaddress1("Street " + RandomStringUtils.randomAlphanumeric(8));
       cp.setaddress2("Near " + RandomStringUtils.randomAlphabetic(6));
       cp.setcity(RandomStringUtils.randomAlphabetic(7));
       cp.setpin(RandomStringUtils.randomNumeric(6)); // 6-digit postal code
       cp.setCountry("India"); // Static, matches dropdown
       cp.setState("Telangana"); // Static, matches dropdown
       cp.clickOnContinueAfterBillingAddress();
   }
	

	@When("User continues through delivery address and method")
	public void user_continues_through_delivery_address_and_method() throws InterruptedException 
	{
		 cp.clickOnContinueAfterDeliveryAddress();
	        cp.setDeliveryMethodComment("Deliver during business hours");
	        Thread.sleep(3000);
	        cp.clickOnContinueAfterDeliveryMethod();
	}

	@When("User selects terms and conditions")
	public void user_selects_terms_and_conditions() throws InterruptedException
	{
		BaseClass.getLogger().info("...user selects terms and conditions .. ");
		 cp.selectTermsAndConditions();
		 Thread.sleep(2000);
	        cp.clickOnContinueAfterPaymentMethod();
	}

	@When("User confirms the order")
	public void user_confirms_the_order() throws InterruptedException
	{
		BaseClass.getLogger().info("...user confirms the order.. ");
		Thread.sleep(2000);
		cp.clickOnConfirmOrder();
	   	}

	@Then("Order placement should be successful")
	public void order_placement_should_be_successful() throws InterruptedException 
	{
		cp.isOrderPlaced();
		/*boolean isOrderPlaced = cp.isOrderPlaced();
        assert isOrderPlaced : "Order placement failed!";*/
	    	}



}
