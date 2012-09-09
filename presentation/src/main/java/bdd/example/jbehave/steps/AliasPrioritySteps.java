package bdd.example.jbehave.steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;

public class AliasPrioritySteps {

   enum State {INIT,FIRST,SECOND}

   private State state;

   @BeforeScenario
   public void setup() {
      state = State.INIT;
   }

   @Given(value="this is a sample step with parameter $param", priority = 0) //set priority to 1 to make this pass
   @Alias("this is a (maybe) aliased step with parameter $param and more text")
   public void oneStep(String parameter) {
      if(this.state != State.INIT) {
         throw new RuntimeException("State is no set to " + State.INIT);
      }
   }

   @Given("this is a (maybe) aliased step with parameter $param")
   public void thisStepAlwaysFails(String parameter) {
      throw new RuntimeException("I don't want to call this step");
   }

}
