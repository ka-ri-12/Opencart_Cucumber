package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage
	{
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-shopping-cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//a//strong//i[@class='fa fa-shopping-cart'][1]")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//tbody//tr//td[6]")
     WebElement lblTotalPrice;  
	
	
	@FindBy(xpath="//div[@class='input-group btn-block']//input[@type='text']")
	WebElement quantityInput;
	
	@FindBy(xpath="//i[@class='fa fa-refresh']" )
	WebElement updateButton;
	
	

	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	
	public void clickItemsToNavigateToCart() throws InterruptedException
	{
		Thread.sleep(2000);
		btnItems.click();
	}
	
	public void clickViewCart() throws InterruptedException
	{
	//	Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//strong//i[@class='fa fa-shopping-cart'][1]")));
		cartIcon.click();

		//lnkViewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public int getQuantity()
	{
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }
	
	public void updateQuantity(int newQuantity) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(newQuantity));
        updateButton.click();
    }

    public void decreaseQuantity(int decreaseBy) {
        int currentQuantity = getQuantity();
        int updatedQuantity = Math.max(1, currentQuantity - decreaseBy); // Ensure quantity >= 1
        updateQuantity(updatedQuantity);
    }
	
	
	public void clickOnCheckout()
	{
		btnCheckout.click();
	}
}
