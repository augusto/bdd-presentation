package bdd.example.jbehave.model;

import java.util.Map;

public class AlbumBuilder {

   public static Album build(Map<String, String> row) {
      String artist = row.get("artist");
      String title = row.get("title");
      int priceInPence = Integer.parseInt(row.get("priceInPence"));

      return new Album(artist,title,priceInPence);
   }
}
