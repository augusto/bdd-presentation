package org.bdd.example.functional_specs;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.StepMonitor;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumContextOutput;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

public class StoryRunner extends JUnitStories {

   private CrossReference crossReference = new CrossReference()
           .withJsonOnly()
           .withOutputAfterEachStory(true)
           .excludingStoriesWithNoExecutedScenarios(true);


   private SeleniumContext seleniumContext = new SeleniumContext();

   private StepMonitor stepMonitor = new SilentStepMonitor();

   private Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML };

   private StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
           .withCodeLocation(codeLocationFromClass(StoryRunner.class))
           .withFailureTrace(true)
           .withFailureTraceCompression(true)
           .withDefaultFormats()
           .withFormats(formats)
           .withCrossReference(crossReference);

   public StoryRunner() {
      configuredEmbedder()
              .embedderControls()
              .doGenerateViewAfterStories(true)
              .doIgnoreFailureInStories(true)
              .doIgnoreFailureInView(true)
              .useThreads(1)
              .useStoryTimeoutInSecs(60);
   }

   @Override
   public Configuration configuration() {
      return new SeleniumConfiguration()
              .useSeleniumContext(seleniumContext)
              .usePendingStepStrategy(new FailingUponPendingStep())
              .useStoryControls(new StoryControls().doResetStateBeforeScenario(true))
              .useStepMonitor(stepMonitor)
              .useStoryLoader(new LoadFromClasspath(StoryRunner.class))
              .useStoryReporterBuilder(reporterBuilder);
   }


   @Override
   public InjectableStepsFactory stepsFactory() {
      String[] configurationFiles = { "steps-context.xml" };

      ApplicationContext context = new ClassPathXmlApplicationContext(configurationFiles);
      return new SpringStepsFactory(configuration(), context);
   }

   @Override
   protected List<String> storyPaths() {
      URL location = codeLocationFromClass(this.getClass());
      return new StoryFinder().findPaths(location, "**/*.story", "none");
   }
}