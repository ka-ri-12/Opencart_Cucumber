package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistAndComparisionFunctionality extends BasePage
{
	
public WishlistAndComparisionFunctionality(WebDriver driver)
{
	super(driver);
}

@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
WebElement addToWishlistButton;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement successMessage;;

//wishlist page

@FindBy(xpath="//td[normalize-space()='Product Name']")
WebElement iPhoneInWishlist;

@FindBy(xpath="//a[@class='btn btn-danger']//i[@class='fa fa-times']")
WebElement removeButton;

@FindBy(xpath="//div[contains(@class, 'alert-success')]")
WebElement modifymessage;

@FindBy(xpath="//p[normalize-space()='Your wish list is empty.']")
WebElement emptyWishlistMessage;

//ComparisonPage

@FindBy(xpath="//i[@class='fa fa-exchange']")
WebElement btncomparison;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement comparisonSuccessMessage;

@FindBy(xpath = "//table[@class='table table-bordered']//td")
private List<WebElement> comparisonTableCells;



public void addToWishlist() {
    addToWishlistButton.click();
}

public String getSuccessMessage() {
    return successMessage.getText();
}

//wishlist page methods

public boolean isProductInWishlist(String productName) {
    return iPhoneInWishlist.isDisplayed();
}

public void removeProduct() {
    removeButton.click();
}

public String getModifyMessage()
{
	return modifymessage.getText();
}

public String getEmptyWishlistMessage() {
    return emptyWishlistMessage.getText();
}

//ComparisonPage
      
public void clickcomparison()
{
	btncomparison.click();
}

public String getComparisonSuccessMessage() {
    return comparisonSuccessMessage.getText();
  //  comparisonSuccessMessage.click();
}

public boolean isProductDisplayedInComparison(String productName) {
    for (WebElement cell : comparisonTableCells) {
        if (cell.getText().contains(productName)) {
            return true;
        }
    }
    return false;
}


}
