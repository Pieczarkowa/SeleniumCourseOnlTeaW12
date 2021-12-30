
Feature: Add new address for user
  Scenario: Create and verify a new address for the user logged in on https://mystore-testlab.coderslab.pl website
    Given Landing page https://mystore-testlab.coderslab.pl opened in browser
    When Sign in button pressed
    And Username and password entered in the form fields and 'Sign in' button pressed
    And Section 'Addresses' on user account page selected
    And Section '+ Create new address' chosen and pressed
 #   And New address form filled out and saved
 #   Then New address for the user added and verified
 #   Examples:
 #     |firstName|lastName   |isMr |password    |isNewsletter|isSpecialOffers|
 #     |ala      | alowska   |false|password    | true       | false         |
 #     |adam     | romanowski|true |xyz123      | false      | true          |
  #    |lu       | xiaojun   |true |heavyLift!  | true       | true          |