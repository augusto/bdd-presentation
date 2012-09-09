package bdd.example.jbehave.steps;

import bdd.example.jbehave.model.Money;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ParametrisedSteps {

   private Map<String,Double> exchangeRates;
   private Money accountBalance;

   @BeforeScenario
   public void setup() {
      accountBalance=null;
      exchangeRates = new HashMap<String, Double>();
      exchangeRates.put("GBP",1.0);
      exchangeRates.put("EUR",1.2629);
      exchangeRates.put("USD",1.5843);
   }

   @Given("I have $currency $amount in my account")
   public void createAccount(String currency, int amount)
   {
      accountBalance = new Money(currency, amount);
   }

   @When("I withdraw $currency $amount$")
   public void withdrawFromAccount(String currency, int amount) {
      Money withdraw = new Money(currency, amount);
      withdraw = withdraw.exchangeTo(currency, exchangeRates);
      accountBalance = accountBalance.withdraw(withdraw);
   }

   @Then("my account balance is $currency $amount")
   public void assertAccountBalance(String currency, int amount) {
      assertThat(accountBalance.getAmount(), equalTo(amount));
   }
}
