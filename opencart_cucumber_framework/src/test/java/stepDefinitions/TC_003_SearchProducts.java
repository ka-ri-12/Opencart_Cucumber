package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.util.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Searchproduct;

public class TC_003_SearchProducts
{

	 WebDriver driver;
     HomePage hp;
     Searchproduct sp;
	
	
	@Given("the user is on the homepage of the website")
	public void the_user_is_on_the_homepage_of_the_website()
	{
		BaseClass.getLogger().info("open home page ");
		hp=new HomePage(BaseClass.getDriver());
		 System.out.println("User navigates to the homepage.");   
	}
	
	@When("the user enters string={string} in the search bar")
	public void the_user_enters_string_in_the_search_bar(String string)
	{
		BaseClass.getLogger().info("enter product in searchbar ");
		sp = new Searchproduct(BaseClass.getDriver());
	    sp.enterProductname(string);
	}

	@When("clicks on the {string} button")
	public void clicks_on_the_button(String string) 
	{
	  sp.clicksearchbtn();
	}

	@Then("the system should display a list of products related to {string}")
	public void the_system_should_display_a_list_of_products_related_to(String string) 
	{
		BaseClass.getLogger().info("validate the list of display products ");
	   sp.getSearchResults();
	}

	@Then("each displayed product should contain the keyword {string} in its name or description.")
	public void each_displayed_product_should_contain_the_keyword_in_its_name_or_description(String string)
	{
		 sp.doResultsContainKeyword(string);
		
		
	}



}
