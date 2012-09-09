package org.bdd.example.functional_specs.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HomePage extends AbstractFluentPage {
   public HomePage(WebDriverProvider driverProvider, String baseUrl) {
      super(driverProvider, baseUrl);
   }

   public void go() {
      get(getBaseUrl()+"app/");
   }

   public void setNumberField(String value) {
      findElement(By.id("number")).sendKeys(value);
   }

   public void setNumberField(int number) {
      setNumberField(Integer.toString(number));
   }

   public void submit() {
      findElement(By.id("submit")).click();
   }

   public void assertResult(long number) {
      waitForAllAjaxToComplete(5000);
      String result = findElement(By.id("result")).getText();
      assertThat(result, equalTo(Long.toString(number)));
   }

   public void assertErrorWithMessage(String expectedMessage) {
      waitForAllAjaxToComplete(5000);
      String actualMessage = findElement(By.className("error")).getText();
      assertThat(actualMessage, equalTo(expectedMessage));
   }
}
