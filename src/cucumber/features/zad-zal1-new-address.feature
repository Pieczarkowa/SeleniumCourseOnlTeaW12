
Feature: Add new address for user
  Scenario Outline: Create and verify a new address for the user logged in on https://mystore-testlab.coderslab.pl website
    Given Landing page https://mystore-testlab.coderslab.pl opened in browser
    When Sign in button pressed
    And Username and password entered in the form fields and 'Sign in' button pressed
    And Section 'Addresses' on user account page selected
    And Section '+ Create new address' chosen and pressed
    And New address form filled out with: <alias>, <address>, <zip/postal code>, <city>, <country>, <phone> and saved
 #   Then New address for the user added and verified
   Examples:
     |alias |address           |zip/postal code|city    |country         |phone       |
     |Ala   |Akacjowa 12       |00-001         |Warsaw  | Poland         | 666 666 666|
     |Alusia|Baker Street 13   |00-002         |London  | United Kingdom | 555 555 555|
     |Alka  |Unter den Linden 8|00-003         |Berlin  | Germany        | 444 444 444|

