package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductAndAddproducttocart extends BasePage
{   
	WebDriver driver;
	
	public SearchProductAndAddproducttocart(WebDriver driver)
	{
		super(driver);
	}	
	
		@FindBy(xpath="//*[@id='content']/div[3]//img")
		List<WebElement> searchProducts;
				
		
		
		@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-shopping-cart']")
		WebElement btnaddToCart;
		
		
		
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		
		@FindBy(xpath="//button[@class='btn btn-danger']") 
		List<WebElement> btnRemoveItems;
		
		public boolean isProductExist(String productName)
		{
			boolean flag=false;
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
				flag=true;
				break;
				}
			}
			
			return flag;
		
		}
		
		public void selectProduct(String productName)
		{
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
					product.click();
				}
			}
		
		}
		
		
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		public void clearCart() {
		    for (WebElement removeButton : btnRemoveItems) {
		        removeButton.click();
		    }
		}
}

