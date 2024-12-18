package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					//features= {".//Features/"},
					//features= {".//Features/Login.feature"},
					//features= {".//Features/Registration.feature"},
		           // features= {".//Features/LoginDDTExcel.feature"},
		
				  // features= {".//Features/Search.feature"},
		          // features= {".//Features/Shoppingcart.feature"},
		         // features= {".//Features/PlaceanOrderForProduct.feature"},
		          //features= {".//Features/wishlist_and_comparison.feature"},
		        //  features={".//Features/Contactus.feature"},
		         //features={".//Features/Logout.feature"},
		           // features={".//Features/order_history.feature"},
		
		
		
		
				//features= {".//Features/Login.feature",".//Features/Registration.feature"},
	            //features= {"@target/rerun.txt"},
		// features= {".//Features/Addproducttocart.feature",".//Features/Shoppingcart.feature"},
		 features={".//Features/Registration.feature",".//Features/Login.feature",".//Features/Search.feature",".//Features/Addproducttocart.feature",".//Features/Shoppingcart.feature",".//Features/wishlist_and_comparison.feature",".//Features/PlaceanOrderForProduct.feature",".//Features/order_history.feature",".//Features/Contactus.feature",".//Features/Logout.feature"},
		            	 
					glue={"stepDefinitions","hooks"},
					plugin= {
								"pretty", 
								"html:reports/Myreports.html",  // HTML report generation 
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",  // ExtentReports plugin
								"rerun:target/rerun.txt",
								
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   // to publish report in cucumber server
					
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner
{
	}


