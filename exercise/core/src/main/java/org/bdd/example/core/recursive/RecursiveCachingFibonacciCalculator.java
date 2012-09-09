package org.bdd.example.core.recursive;

import org.bdd.example.core.FibonacciCalculator;

public class RecursiveCachingFibonacciCalculator implements FibonacciCalculator {

   private static final int MAX_FIB = 93;

   private final long[] cache = new long[MAX_FIB];

   public RecursiveCachingFibonacciCalculator() {
      for(int i=0 ; i < MAX_FIB ; i++) {
         cache[i] = -1;
      }
   }

   @Override
   public long calculate(int number) {
      if( number < 0) {
         throw new IllegalArgumentException("Number must be greater or equal to 0");
      } else if(number >= MAX_FIB) {
         throw new IllegalArgumentException("Number must be smaller than " + MAX_FIB);
      }

      return fibonacci(number);
   }

   private long fibonacci(int number) {
      long fibonacciNumber=0;
      if( cache[number] != -1) {
         fibonacciNumber =  cache[number];
      } else {
         switch(number) {
            case 0:  fibonacciNumber = 0;
                     break;
            case 1:  fibonacciNumber = 1;
                     break;
            default: fibonacciNumber = fibonacci(number - 1) + fibonacci(number - 2);
         }
         cache[number] = fibonacciNumber;
      }

      return fibonacciNumber;
   }
}
