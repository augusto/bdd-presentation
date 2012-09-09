package org.bdd.example.core.cyclic;

import org.bdd.example.core.FibonacciCalculator;

public class CyclicFibonacciCalculator implements FibonacciCalculator{


   @Override
   public long calculate(final int number) {
      if( number < 0) {
         throw new IllegalArgumentException("Number must be greater or equal to 0");
      }

      return fibonacci(number);
   }

   private long fibonacci(final int number) {

      long previousFibonacciNumber=0;
      long fibonacciNumber=0;

      for(int i=0; i < number+1 ;i++) {
         long nextFibonacciNumber = previousFibonacciNumber + fibonacciNumber;
         previousFibonacciNumber=fibonacciNumber;
         fibonacciNumber= nextFibonacciNumber;

         if( i==1) {
            fibonacciNumber=1;
         }
      }

      return fibonacciNumber;
   }
}
