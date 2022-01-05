
Feature: Add new address for user
  Scenario Outline: Create and verify a new address for the user logged in on https://mystore-testlab.coderslab.pl website
    Given Landing page https://mystore-testlab.coderslab.pl opened in browser
    When Sign in button pressed
    And Username and password entered in the form fields and 'Sign in' button pressed
    And Section 'Addresses' on user account page selected
    And Section '+ Create new address' chosen and pressed
    And New address form filled out with: <alias>, <address>, <zip/postal code>, <city>, <country>, <phone> then checked and saved
    And New address deleted
    Then New address deletion confirmed
   Examples:
     |alias |address           |zip/postal code|city     |country         |phone       |
     |Ala   |Abbey Drive 12    |00-001         |Glasgow  | United Kingdom | 666 666 666|
     |Alusia|Baker Street 13   |00-002         |London   | United Kingdom | 555 555 555|
     |Alka  |Penny Lane 8      |00-003         |Liverpool| United Kingdom | 444 444 444|

