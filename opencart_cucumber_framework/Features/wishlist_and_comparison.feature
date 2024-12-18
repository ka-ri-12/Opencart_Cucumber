Feature: Wishlist and Comparison functionality

 @sanity @regression
  Scenario: Verify end-to-end wishlist and comparison functionality  
  # Log in and add a product to the wishlist  
  Given User is on the login page  
  When User logs in with valid credentials  
  Then User is redirected to the homepage  

  When User browses products and adds "iPhone" to the wishlist  
  Then Product "iPhone" is successfully added to the wishlist with a success message  

  # View the wishlist  
  When User navigates to the wishlist page  
  Then Product "iPhone" is displayed in the wishlist  

  # Add multiple products to the comparison list  
  When User adds the following products to the comparison list:  
    | Product  |  
    | iPhone   |  
    | MacBook  |  
  Then Products are successfully added to the comparison list with a success message  

  # View the comparison list  
  When User navigates to the comparison page  
  Then Products are displayed side-by-side with key attributes  

  # Remove a product from the wishlist  
  When User navigates to the wishlist page and removes product "iPhone"  
  Then Product "iPhone" is removed from the wishlist with a success message  

  Then The wishlist page displays a message indicating it is empty  


