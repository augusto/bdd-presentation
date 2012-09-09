package bdd.example.jbehave.model;

public class Album {
   private String artist;
   private String title;
   private int priceInPence;

   public Album(String artist, String title, int priceInPence) {
      this.artist = artist;
      this.title = title;
      this.priceInPence = priceInPence;
   }

   public String getArtist() {
      return artist;
   }

   public String getTitle() {
      return title;
   }

   public int getPriceInPence() {
      return priceInPence;
   }

   public boolean equals(String artist, String title) {
      return this.artist.equals(artist) &&
             this.title.equals(title);
   }

   @Override
   public String toString() {
      return "Album{" +
              "artist='" + artist + '\'' +
              ", title='" + title + '\'' +
              ", priceInPence=" + priceInPence +
              '}';
   }
}
