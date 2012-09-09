package org.bdd.example.core.recursive;

import org.bdd.example.core.FibonacciCalculator;

public class RecursiveFibonacciCalculator implements FibonacciCalculator {

   public static void main(String[] args) {
      RecursiveFibonacciCalculator calc = new RecursiveFibonacciCalculator();
      for( int i = 0 ; i < 50 ; i++) {
         long result = calc.calculate(i);

         System.out.printf("%d - for %d value %d  -  loops (%d)\n",System.currentTimeMillis(), i, result, calc.getLoops());
      }
   }

   private long loops;

   public long getLoops() {
      return loops;
   }

   @Override
   public long calculate(int number) {
      loops=0;
      if( number < 0) {
         throw new IllegalArgumentException("Number must be greater or equal to 0");
      }

      return fibonacci(number);
   }

   private long fibonacci(int number) {
      loops++;
      switch(number) {
         case 0: return 0;
         case 1: return 1;
         default: return fibonacci(number-1) + fibonacci(number-2);
      }
   }
}
