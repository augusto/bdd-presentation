package org.bdd.example.core.recursive;

import org.bdd.example.core.AbstractFibonacciCalculatorTest;
import org.bdd.example.core.FibonacciCalculator;

public class RecursiveCachingFibonacciCalculatorTest extends AbstractFibonacciCalculatorTest{

   @Override
   public FibonacciCalculator instantiate() {
      return new RecursiveCachingFibonacciCalculator();
   }
}
