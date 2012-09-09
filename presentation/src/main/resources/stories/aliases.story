Description: show how aliases and pattern variants work


Scenario: Use a pattern variant
When the item cost is 10.0
When the price is 10.0
When the cost is 10.0


Scenario: Use aliases
Then the item price is 10.0
Then the item price becomes 10.0
Then the item price equals to 10.0


Scenario: Use a step annotated with Given, When, Then
Given one step
When the same step is called
Then the same step is executed


Scenario: Aliasing a method which is annotated with Given, When, Then
Given I want to alias everything
When I want to alias everything
Then I want to alias everything
