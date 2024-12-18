package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchproduct extends BasePage
{
public Searchproduct(WebDriver driver)
{
	super(driver);
}

@FindBy(xpath = "//input[@placeholder='Search']")
WebElement searchbar;

@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
WebElement clickbutton;

@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']")
 List<WebElement> productTitles; // Locator for product titles in search results



public void enterProductname(String string) {
	searchbar.clear();
	searchbar.sendKeys(string);
}

public void clicksearchbtn() {
	clickbutton.click();
}


public List<String> getSearchResults() {
    List<String> productNames = new ArrayList<>();
    for (WebElement product : productTitles) {
        productNames.add(product.getText());
    }
    return productNames;
}
public boolean doResultsContainKeyword(String string) {
    List<String> products = getSearchResults();
    for (String product : products) {
        if (!product.toLowerCase().contains(string.toLowerCase())) {
            return false;
        }
    }
    return true;
}





}
