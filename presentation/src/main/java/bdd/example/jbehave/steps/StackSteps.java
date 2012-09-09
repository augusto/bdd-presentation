package bdd.example.jbehave.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class StackSteps {
   private Stack<String> stack;
   private Exception exception;

   @BeforeScenario
   public void setup() {
      stack = null;
      exception = null;
   }

   @Given("a new stack")
   public void createNewStack() {
      stack = new Stack<String>();
   }

   @When("I push the string $string")
   public void pushString(String stringToPush) {
      stack.push(stringToPush);
   }

   @Then("I can pop the string $string")
   public void assertPopValue(String string) {
      assertThat(stack.pop(), equalTo(string));
   }

   @Then("the stack is not empty")
   public void assertStackIsNotEmpty() {
      assertThat(stack.empty(), is(false));
   }

   @Then("the stack is empty")
   public void assertStackIsEmpty() {
      assertThat(stack.empty(), is(true));
   }

   @When("I try to pop a value")
   public void popValue() {
      try {
         stack.pop();
      } catch (Exception e) {
         exception = e;
      }
   }

   @Then("an exception is thrown")
   public void assertExceptionIsThrown() {
      assertThat(exception, notNullValue());
   }

   @Then("the stack size is $size")
   public void assertStackSize(int size) {
      assertThat(stack.size(), equalTo(size));
   }
}
