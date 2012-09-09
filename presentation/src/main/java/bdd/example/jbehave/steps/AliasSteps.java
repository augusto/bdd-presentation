package bdd.example.jbehave.steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AliasSteps {

   @When("the {item |}{price|cost} is $price")
   public void variant_theItemPriceIs(double price) {
      System.out.println("Price: " + price);
   }

   @Then("the item price is $price")
   @Aliases(values={"the item price becomes $price",
                    "the item price equals to $price"})
   public void alias_theItemPriceIs(double price) {
      System.out.println("Price: " + price);
   }


   @Given("one step")
   @When("the same step is called")
   @Then("the same step is executed")
   @Alias("I want to alias everything")
   public void sameMethodDifferentSteps() {

   }

}
