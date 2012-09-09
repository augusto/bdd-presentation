package org.bdd.example.web.controller;

import org.bdd.example.core.FibonacciCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Pattern;

import static org.bdd.example.web.controller.Validator.isInteger;

@Controller
public class TestController {

   private FibonacciCalculator fibonacciCalculator;

   @Autowired
   public TestController(FibonacciCalculator fibonacciCalculator) {
      this.fibonacciCalculator = fibonacciCalculator;
   }

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String renderHomePage() {
      return "home";
   }

   @RequestMapping(value = "/fibonacci/{numberString}", method = RequestMethod.GET)
   @ResponseBody
   public String calculateFibonacci(@PathVariable String numberString) {
       numberString = numberString.trim();
       if(!isInteger(numberString)) {
           return error("Please enter a number");
       }

       int number = Integer.parseInt(numberString);

       try {
         long fibonacciNumber = fibonacciCalculator.calculate(number);
         return Long.toString(fibonacciNumber);
      } catch(IllegalArgumentException iae) {
         return error(iae.getMessage());
      }
   }

    private String error(String message) {
        return "<span class=\"error\">" + message + "</span>";
    }
}
