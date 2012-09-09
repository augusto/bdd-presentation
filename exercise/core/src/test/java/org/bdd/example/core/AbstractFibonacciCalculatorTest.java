package org.bdd.example.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class AbstractFibonacciCalculatorTest {
   FibonacciCalculator fibonacciCalculator;

   @Before
   public void setup() {
      fibonacciCalculator = instantiate();
   }

   public abstract FibonacciCalculator instantiate();

   @Test
   public void should_return_zero_when_input_is_zero() {
      assertThat(fibonacciCalculator.calculate(0), equalTo(0l));
   }

   @Test
   public void should_return_one_when_input_is_one() {
      assertThat(fibonacciCalculator.calculate(1), equalTo(1l));
   }

   @Test
   public void should_calculate_the_fibonacci_number_correctly() {
      assertThat(fibonacciCalculator.calculate(13), equalTo(233l));
   }

   @Test(expected = IllegalArgumentException.class)
   public void should_throw_exception_if_number_is_negative() {
      fibonacciCalculator.calculate(-1);
   }
}
