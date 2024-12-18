Feature: View Order History and Details
  @regression
  Scenario: View order history and details of a specific order
    Given the user is logged into their account on website
    When the user navigates to the Order History page through the My Account menu
    Then the user should see a list of their past orders, including Order ID, Status, and Total Cost
    When the user clicks on the View button for a specific order
    Then the user should see detailed information about the selected order
