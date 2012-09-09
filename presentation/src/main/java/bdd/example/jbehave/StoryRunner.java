package bdd.example.jbehave;

import bdd.example.jbehave.steps.AliasPrioritySteps;
import bdd.example.jbehave.steps.AliasSteps;
import bdd.example.jbehave.steps.ParametrisedSteps;
import bdd.example.jbehave.steps.PrioritySteps;
import bdd.example.jbehave.steps.StackSteps;
import bdd.example.jbehave.steps.TabularParameterSteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.SilentStepMonitor;

import java.net.URL;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

public class StoryRunner extends JUnitStories {

   public StoryRunner() {
      configuredEmbedder().embedderControls()
              .doGenerateViewAfterStories(true)
              .doIgnoreFailureInStories(true)
              .doIgnoreFailureInView(true)
              .useThreads(1)
              .useStoryTimeoutInSecs(60);
   }

   @Override
   public Configuration configuration() {
      Class<? extends Embeddable> embedderClass = this.getClass();

      URL codeLocation = CodeLocations.codeLocationFromClass(embedderClass);

      Configuration configuration = new MostUsefulConfiguration()
              .useStoryLoader(new LoadFromClasspath(embedderClass))
              .useStoryReporterBuilder(new StoryReporterBuilder()
                      .withCodeLocation(codeLocation)
                      .withDefaultFormats()
                      .withFormats(CONSOLE, TXT, HTML, XML)
                      .withFailureTrace(true))
              .useStepMonitor(new SilentStepMonitor())
              .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));

      return configuration;
   }

   @Override
   public final InjectableStepsFactory stepsFactory() {
      return new InstanceStepsFactory(
              configuration(),
              new StackSteps(),
              new TabularParameterSteps(),
              new ParametrisedSteps(),
              new AliasSteps(),
              new PrioritySteps(),
              new AliasPrioritySteps()
      );
   }

   @Override
   protected List<String> storyPaths() {
      URL location = codeLocationFromClass(this.getClass());

      String includeFiles = "**/*.story";
      String excludeFiles = "none";

      return new StoryFinder().findPaths(location, includeFiles, excludeFiles);
   }

}
