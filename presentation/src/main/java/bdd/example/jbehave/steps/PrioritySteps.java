package bdd.example.jbehave.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;

public class PrioritySteps {

   enum Step {INIT, FIRST, SECOND, THIRD}

   private Step currentStep;

   @BeforeScenario
   public void setup() {
      currentStep=Step.INIT;
   }

   @Given("the user $user")
   public void givenTheUserJohnDoe(String user) {
      if( currentStep != Step.INIT) {
         throw new RuntimeException("Expected to be at the initial step");
      }
      currentStep = Step.FIRST;
   }

   @Given(value="the user $user with password $password", priority = 0)
   public void givenTheUserJohnDoeWithPasswordSecret11(String user, String password) {
      if( currentStep != Step.FIRST) {
         throw new RuntimeException("Expected to be at the initial step");
      }

      currentStep = Step.SECOND;
   }

   @Given(value="the user $user with password $password who has $role privileges", priority = 0)
   public void givenTheUserJohnDoeWithPasswordSecret11WhoHasAdminPrivileges(String user, String password, String role) {
      if( currentStep != Step.SECOND) {
         throw new RuntimeException("Expected to be at the initial step");
      }
   }

}
