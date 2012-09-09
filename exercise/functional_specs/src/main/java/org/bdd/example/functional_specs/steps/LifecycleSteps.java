package org.bdd.example.functional_specs.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.web.selenium.PerStoryWebDriverSteps;
import org.jbehave.web.selenium.WebDriverProvider;

public class LifecycleSteps extends PerStoryWebDriverSteps {

   public LifecycleSteps(WebDriverProvider webDriverProvider) {
      super(webDriverProvider);
   }

}
