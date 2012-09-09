package org.bdd.example.functional_specs.steps;

import org.bdd.example.functional_specs.pages.HomePage;
import org.bdd.example.functional_specs.pages.PageFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FibonacciSteps {

    private final HomePage homePage;

    public FibonacciSteps(PageFactory pageFactory) {
        homePage = pageFactory.homePage();
    }

    @Given("I'm at the home page of the Ultimate Fibonacci Calculator")
    public void go_to_the_home_page() {
        homePage.go();
    }

    @When("I enter the number ${number} on the Ultimate Fibonacci Calculator")
    public void enterNumber(int number) {
        homePage.setNumberField(number);
    }

    @When("submit the page")
    public void whenSubmitThePage() {
        homePage.submit();
    }

    @Then("I get back the result ${result}")
    public void assertResult(long result) {
        homePage.assertResult(result);
    }

    @When("I enter \"$text\" on the Ultimate Fibonacci Calculator")
    public void enterString(String text) {
        homePage.setNumberField(text);
    }

    @Then("I get back an error with the text: \"$message\"")
    public void assertErrorMessage(String message) {
        homePage.assertErrorWithMessage(message);
    }


}
