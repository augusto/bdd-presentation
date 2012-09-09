Description: show how tables can be used in JBehave


Scenario: Use a table as a step parameter
Given the product list:
|artist|title|priceInPence|
|Arcade Fire|Neon Bible|720|
|Pavement|Brighten the Corners|340|
|Aphex Twin|Come To Daddy|1070|
When I add the album Brighten the Corners by Pavement to my basket
And I add the album Come To Daddy by Aphex Twin to my basket
And I go to the checkout
Then the total in the basket is 1410
