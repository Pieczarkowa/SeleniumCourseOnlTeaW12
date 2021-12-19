Feature: Qwant search

  Scenario: Search for "W pustyni i w puszczy" in https://www.qwant.com/
    Given Web page https://www.qwant.com/ opened in browser
   When Search phrase "W pustyni i w puszczy" entered in search input box
  And key entered pressed
  Then First 3 search results titles contain phrase "W pustyni i w puszczy"


  Scenario Outline: Search for "<searchPhrase>" in https://www.qwant.com/
    Given Web page https://www.qwant.com/ opened in browser
    When Search phrase "<searchPhrase>" entered in search input box
    And key entered pressed
    Then First 3 search results titles contain phrase "<searchPhrase>"
    #zeby nbie trzeba bylo tego wszystkie powtarzac robi sie scenario outline
  Examples:
    |searchPhrase         |resultsCount |
    |W pustyni i w puszczy|5            |
    |Pharaoh              |3            |