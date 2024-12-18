Feature: Place an order for a product
 @sanity @regression
  Scenario: Successfully place an order for HP LP3065 product
    Given User is on the homepage of the website
    #When user enters email as "nashmask67@gmail.com" and password as "nashma@12"
   # And the user clicks on the Login button
    When User searches for "HP LP3065" product
    And User adds the product to the cart
    And User proceeds to checkout
    And User enters random billing details
    And User continues through delivery address and method
    And User selects terms and conditions
    And User confirms the order
    Then Order placement should be successful
