package org.bdd.example.functional_specs.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class PageFactory {

   private final WebDriverProvider driverProvider;
   private final String baseUrl;

   public PageFactory(WebDriverProvider driverProvider, String baseUrl) {
      this.driverProvider = driverProvider;
      this.baseUrl = baseUrl;
   }

   public HomePage homePage() {
      return new HomePage(driverProvider, baseUrl);
   }
}
