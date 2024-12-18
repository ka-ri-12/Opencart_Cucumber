Feature: Contact Us Form

  Scenario: Successful Submission of the Contact Us Form
  Given the user is on the "Contact Us" page
  When the user fills out the form with valid data
  And the user clicks the "Submit" button
  Then the "Continue" button should be displayed

