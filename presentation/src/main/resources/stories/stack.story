Description: a description of the story

Narrative:
In order to build an application to rule the world
As an evil developer
I want to use a stack.

Scenario: New stack should be empty
Given a new stack
Then the stack is empty


Scenario: Can push an item to the stack
Given a new stack
When I push the string Hello World
Then the stack is not empty


Scenario: Can push and pop an item from the stack
Given a new stack
When I push the string Hello World
Then I can pop the string Hello World


Scenario: The stack behaves as a 'Last-In, First-Out' queue (LIFO)
Given a new stack
When I push the string Hello World
And I push the string Bye, Bye World
Then I can pop the string Bye, Bye World
Then I can pop the string Hello World


Scenario: Cannot pop a value from an empty stack
!-- This scenario is wrong from a story point of view, as a user will never expect an exception.
!-- Nevertheless, it would be valid in an unit specification.
Given a new stack
When I try to pop a value
Then an exception is thrown


Scenario: I can get the number of items in the stack
Given a new stack
When I push the string Hello World
And I push the string Bye, Bye World
And I push the string Brave New World
Then the stack size is 3