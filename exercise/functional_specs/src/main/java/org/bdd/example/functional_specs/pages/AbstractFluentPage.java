package org.bdd.example.functional_specs.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;

public class AbstractFluentPage extends FluentWebDriverPage {
    private final String baseUrl;

    public AbstractFluentPage(WebDriverProvider driverProvider, String baseUrl) {
        super(driverProvider);
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }


    public void waitForAllAjaxToComplete(int timeoutInMillis) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriverProvider().get();
        boolean isComplete = false;
        long expiryTime = System.currentTimeMillis() + timeoutInMillis;

        while( isComplete == false || expiryTime > System.currentTimeMillis()) {
            isComplete = (Boolean)javascriptExecutor.executeScript("return jQuery.active == 0");
            if( isComplete == false) {
                sleep(100);
            }
        }

        if( isComplete == false) {
            throw new TimeoutException("There is still an active ajax connection");
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
