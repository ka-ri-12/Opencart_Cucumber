Feature: Login with Valid Credentials

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "nashmask67@gmail.com" and password as "nashma@12"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

  #@regression
 # Scenario Outline: Login Data Driven
   # Given the user navigates to login page
   # When user enters email as "<email>" and password as "<password>"
    #And the user clicks on the Login button
   # Then the user should be redirected to the MyAccount Page

   # Examples: 
    #  | email                     | password |
     # |   nashmask67@gmail.com    | nashma@12 |
     # | test12@gmail.com           | test@123 |
