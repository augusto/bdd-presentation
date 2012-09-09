package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

   public static void main(String[] args) throws IOException {
      FileWriter writer = new FileWriter("c:\\dev\\load.sql");
      Random random = new Random();

      for( int i=1 ; i < 1000000 ; i++ ) {
         int tableNumber = (i%20) + 1;
         String tableName = "metrics" + tableNumber;
         String randomString = random.nextInt() + "." + random.nextInt() + "." + random.nextInt();
         writer.append("insert into " + tableName + "(data) values('this is a test with a random number " + randomString + "');");
         writer.append("\n");
      }

      writer.close();

   }
}
