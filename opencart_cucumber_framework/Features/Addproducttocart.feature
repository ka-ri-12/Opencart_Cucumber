Feature:Search product and add to cart 
 @regression
  Scenario: Successfully Search and Add a Product to the Cart
    When the user searches for productName="iPhone"
    And the product "iPhone" exists in the search results
    And the user selects the product "iPhone"
    And clicks the "Add to Cart" button
    Then a confirmation message should be displayed
    
