package org.bdd.example.core.cyclic;

import org.bdd.example.core.AbstractFibonacciCalculatorTest;
import org.bdd.example.core.FibonacciCalculator;

public class CyclicFibonacciCalculatorTest extends AbstractFibonacciCalculatorTest {

   @Override
   public FibonacciCalculator instantiate() {
      return new CyclicFibonacciCalculator();
   }
}
