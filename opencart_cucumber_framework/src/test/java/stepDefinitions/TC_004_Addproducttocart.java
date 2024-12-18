package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.SearchProductAndAddproducttocart;

public class TC_004_Addproducttocart 
{
	 WebDriver driver;
	 SearchProductAndAddproducttocart sp;
	 
	

@When("the user searches for productName={string}")
public void the_user_searches_for_product_name(String string)
{
	BaseClass.getLogger().info("search for product ");

	sp=new SearchProductAndAddproducttocart(BaseClass.getDriver()) ;
	
    }
 
	

	 @When("the product {string} exists in the search results")
	 public void the_product_exists_in_the_search_results(String productName) 
	 {
		 BaseClass.getLogger().info("product exist ");

		 sp.isProductExist(productName);
	 }

	 @When("the user selects the product {string}")
	 public void the_user_selects_the_product(String productName) 
	 {
		 sp.selectProduct(productName);
		 BaseClass.getLogger().info("select the product ");

	    	 }

	
	 
	 @And("^clicks the \"Add to Cart\" button$")
	    public void clicksAddToCartButton()
	 {
		 sp.addToCart();
		 BaseClass.getLogger().info("added to cart ");

	       
	    }

	 @Then("a confirmation message should be displayed")
	 public void a_confirmation_message_should_be_displayed() 
	 {
	    sp.checkConfMsg();
	    BaseClass.getLogger().info("confirm msg ");

	 }



	 
	
}
