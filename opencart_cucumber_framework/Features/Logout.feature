Feature: User Logout


    Scenario: Successful Logout from the Account
    Given the user is logged into their account
    When the user clicks on the "Logout" link in the account menu
    Then the user should be redirected to the "Account Logout" page
    And the user should see the confirmation message
    And the user click on the "Continue" button