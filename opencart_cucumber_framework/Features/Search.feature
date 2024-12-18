Feature: Search Product

@regression
 Scenario: Search for an existing product
  Given the user is on the homepage of the website
  When the user enters string="MacBook" in the search bar
  And clicks on the "Search" button
  Then the system should display a list of products related to "MacBook"
  And each displayed product should contain the keyword "MacBook" in its name or description.