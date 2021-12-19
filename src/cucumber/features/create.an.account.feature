#zad 2 cucumber
Feature: Create an account
Scenario: Register an account on https://hotel-testlab.coderslab.pl/
Given Landing page https://hotel-testlab.coderslab.pl/en/ opened in browser
When Sign in button pressed
And provided email address in Create an account section
And Create an account button pressed
And New user form filled out
And Register button pressed
Then New account registered on https://hotel-testlab.coderslab.pl/ website

