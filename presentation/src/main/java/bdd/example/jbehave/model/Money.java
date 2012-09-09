package bdd.example.jbehave.model;

import java.util.Map;

public class Money {
   private final String currency;
   private final int amount;

   public Money(String currency, int amount) {
      this.currency = currency;
      this.amount = amount;
   }

   public String getCurrency() {
      return currency;
   }

   public int getAmount() {
      return amount;
   }

   @Override
   public String toString() {
      return "Money{" +
              "currency='" + currency + '\'' +
              ", amount=" + amount +
              '}';
   }

   public Money withdraw(Money withdraw) {
      return new Money(currency, amount - withdraw.amount);
   }

   public Money exchangeTo(String currency, Map<String, Double> exchangeRates) {
      Double exchangeRate = exchangeRates.get(currency);

      return new Money(currency, (int) (amount*(1/exchangeRate)));
   }
}
