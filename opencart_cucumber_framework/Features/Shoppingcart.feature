Feature:Shopping cart functionality

Scenario: Verify user can view cart details ,increase product quantity and decrease product quantity
    Given the user is on the Home page
    When the user clicks on the cart items button
    And the user clicks on the "View Cart" link
    Then the total price in the cart should be displayed as $602.00
    
    When the user increases the quantity of the product by 2
    Then the product quantity should be increased by 2
    And the total price should reflect the updated quantity (quantity * price)

    When the user decreases the quantity of the product by 1
    Then the product quantity should be decreased by 1
    And the total price should reflect the updated quantity (quantity * price)

    When the user attempts to decrease the quantity of the product while the quantity is 1
    Then the product quantity should remain 1
    And the total price should remain unchanged

    When the user clicks on the "Checkout" button