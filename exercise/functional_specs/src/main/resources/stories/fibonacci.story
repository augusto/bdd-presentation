Narrative:
In order to validate my calculations
As a math geek
I want to be able to calculate a Fibonacci number

Scenario: I can calculate a standard fibonacci number
Given I'm at the home page of the Ultimate Fibonacci Calculator
When I enter the number 7 on the Ultimate Fibonacci Calculator
And submit the page
Then I get back the result 13


Scenario: I get an error if the number cannot be converted to a number
Given I'm at the home page of the Ultimate Fibonacci Calculator
When I enter "this is so cool!" on the Ultimate Fibonacci Calculator
And submit the page
Then I get back an error with the text: "Please enter a number"


Scenario: I get an error if number is negative
Given I'm at the home page of the Ultimate Fibonacci Calculator
When I enter the number -12 on the Ultimate Fibonacci Calculator
And submit the page
Then I get back an error with the text: "Number must be greater or equal to 0"
