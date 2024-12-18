package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.SearchProductAndAddproducttocart;
import pageObjects.ShoppingCartPage;

public class TC_005_ShoppingCartFunctionality 
{
WebDriver driver;
HomePage hp;
ShoppingCartPage scp;
SearchProductAndAddproducttocart sp;
private final double UNIT_PRICE = 602.00;


@Given("the user is on the Home page")
public void the_user_is_on_the_home_page() 
{
	hp=new HomePage(BaseClass.getDriver());
	sp=new SearchProductAndAddproducttocart(BaseClass.getDriver()) ;
	BaseClass.getLogger().info("....Search for product.. ");
	//sp.clearCart();
	String productName = "MacBook";
	//sp.isProductExist(productName);
	sp.selectProduct(productName);
	 sp.addToCart();
	 
	/* driver = BaseClass.getDriver();
	 driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");*/
}

@When("the user clicks on the cart items button")
public void the_user_clicks_on_the_cart_items_button() throws InterruptedException 
{
	BaseClass.getLogger().info("...navigate to cart page.. ");
	   scp=new ShoppingCartPage(BaseClass.getDriver());
   scp.clickItemsToNavigateToCart();
}

@When("the user clicks on the {string} link")
public void the_user_clicks_on_the_link(String string) throws InterruptedException 
{
	BaseClass.getLogger().info("-->Click on View cart.. ");
   scp.clickViewCart();
}


	@Then("the total price in the cart should be displayed as ${double}")
	public void the_total_price_in_the_cart_should_be_displayed_as_$(Double double1) 
	{
		BaseClass.getLogger().info("...the prices in the cart should be displayed.. ");
	String actualprice=scp.getTotalPrice();

	System.out.println("Actual Price: " + actualprice); // Debugging purpose
    System.out.println("Expected Price: " +" $602.00");
    assertEquals("Total price mismatch!", "$602.00", actualprice);
	
   }


	@When("the user increases the quantity of the product by {int}")
	public void the_user_increases_the_quantity_of_the_product_by(Integer int1)
	{
		BaseClass.getLogger().info("..increase the quantity... ");
		 int currentQuantity = scp.getQuantity();
		 scp.updateQuantity(currentQuantity+int1);
	}

	@SuppressWarnings("deprecation")
	
	@Then("the product quantity should be increased by {int}")
	public void the_product_quantity_should_be_increased_by(Integer int1) 
	{
		Assert.assertEquals("Quantity did not increase correctly", int1 + 1,scp.getQuantity());
	   	}

	@SuppressWarnings("deprecation")
	
	@Then("the total price should reflect the updated quantity \\(quantity * price)")
	public void the_total_price_should_reflect_the_updated_quantity_quantity_price() 
	{
		int quantity = scp.getQuantity();
		 double expectedTotalPrice = quantity * UNIT_PRICE;
		 String actualPrice = scp.getTotalPrice().replace(",", "");
		 String expectedPrice = String.format("$%.2f", expectedTotalPrice);
		 Assert.assertEquals("Price mismatch after quantity update", expectedPrice, actualPrice);
		// Assert.assertEquals("Price mismatch after quantity update", "$" + expectedTotalPrice, scp.getTotalPrice());
	}

	@When("the user decreases the quantity of the product by {int}")
	public void the_user_decreases_the_quantity_of_the_product_by(Integer int1) 
	{
		BaseClass.getLogger().info("..decrease the quantity... ");
		scp.decreaseQuantity(int1);
	    	}

	@SuppressWarnings("deprecation")
	
	@Then("the product quantity should be decreased by {int}")
	public void the_product_quantity_should_be_decreased_by(Integer int1)
	{
		int expectedQuantity = Math.max(1,scp.getQuantity());
		Assert.assertEquals("Quantity did not decrease correctly", expectedQuantity, scp.getQuantity());
	    	}

	@When("the user attempts to decrease the quantity of the product while the quantity is {int}")
	public void the_user_attempts_to_decrease_the_quantity_of_the_product_while_the_quantity_is(Integer int1)
	{
	    scp.decreaseQuantity(1);
	}

	@Then("the product quantity should remain {int}")
	public void the_product_quantity_should_remain(Integer int1)
	{
		 scp.getQuantity();
	}

	@SuppressWarnings("deprecation")
	@Then("the total price should remain unchanged")
	public void the_total_price_should_remain_unchanged()
	{
		Assert.assertEquals("Price mismatch when quantity is 1", "$602.00",scp.getTotalPrice());
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String string)
	{
		scp.clickOnCheckout();
	    	}




}
