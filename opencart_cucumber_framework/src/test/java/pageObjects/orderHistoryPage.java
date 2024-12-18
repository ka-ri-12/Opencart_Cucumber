package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orderHistoryPage extends BasePage
{
public orderHistoryPage(WebDriver driver)
{
	super(driver);
}


@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Order History']")
WebElement orderHistoryMenu;

@FindBy(xpath = "//div[@class='table-responsive']//tr")
private List<WebElement> orderList;

@FindBy(xpath = "//td[@class='text-right']//a[@class='btn btn-info']")
private List<WebElement> viewButtons;

@FindBy(xpath = "//div[@class='table-responsive']")
private WebElement orderDetailsTable;

//details of order table

// Product name in the order details table
@FindBy(xpath = "//div[@class='table-responsive']//td[1][@class='text-left']")
private List<WebElement> productNames;

// Model in the order details table
@FindBy(xpath = "//div[@class='table-responsive']//td[2][@class='text-left']")
private List<WebElement> models;

//Quantity in the order details table
@FindBy(xpath = "//div[@class='table-responsive']//td[3]")
private List<WebElement> quantities;

//Price in the order details table
@FindBy(xpath = "//div[@class='table-responsive']//td[4]")
private List<WebElement> prices;


//Navigate to Order History Page

public void goToOrderHistory() {
    orderHistoryMenu.click();
}

// Get the list of orders

public List<WebElement> getOrders() {
    return orderList;
}

// Click "View" for a specific order

public void clickViewButton(int orderIndex) {
    viewButtons.get(orderIndex).click();
}

// Verify order details are displayed

public boolean isOrderDetailsDisplayed() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orderDetailsTable));
        return orderDetailsTable.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}



// Get details of a specific order

public boolean isOrderDetailsTableDisplayed() {
    return orderDetailsTable.isDisplayed();
}

//Method to retrieve product names
public List<String> getProductNames() {
    List<String> productNamesList = new ArrayList<>();
    for (WebElement product : productNames) {
        productNamesList.add(product.getText());
    }
    return productNamesList;
}

// Method to retrieve models
public List<String> getModels() {
    List<String> modelsList = new ArrayList<>();
    for (WebElement model : models) {
        modelsList.add(model.getText());
    }
    return modelsList;
}

// Method to retrieve quantities
public List<String> getQuantities() {
    List<String> quantitiesList = new ArrayList<>();
    for (WebElement quantity : quantities) {
        quantitiesList.add(quantity.getText());
    }
    return quantitiesList;
}

// Method to retrieve prices
public List<String> getPrices() {
    List<String> pricesList = new ArrayList<>();
    for (WebElement price : prices) {
        pricesList.add(price.getText());
    }
    return pricesList;
}
}































