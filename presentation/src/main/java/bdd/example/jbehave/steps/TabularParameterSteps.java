package bdd.example.jbehave.steps;

import bdd.example.jbehave.model.Album;
import bdd.example.jbehave.model.AlbumBuilder;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TabularParameterSteps {

   List<Album> albums;
   Set<Album> basket;

   @BeforeScenario
   public void setup() {
      albums = new ArrayList<Album>();
      basket = new HashSet<Album>();
   }

   @Given("the product list: $productList")
   public void addProducts(ExamplesTable table) {
      for (Map<String, String> row : table.getRows()) {
         albums.add(AlbumBuilder.build(row));
      }
   }

   @When("I add the album $title by $artist to my basket")
   public void addAlbumToBasket(String title, String artist) {
      for(Album album : albums) {
         if( album.equals(artist, title)) {
            basket.add(album);
            break;
         }
      }
   }

   @When("I go to the checkout")
   public void whenIGoToTheCheckout() {
      // do nothing
   }

   @Then("the total in the basket is $totalPrice")
   public void assertBasketTotalIs(int expectedTotalPriceInPence) {
      int totalPrice=0;
      for(Album albumInBasket : basket) {
         totalPrice += albumInBasket.getPriceInPence();
      }
      assertThat(totalPrice, equalTo(expectedTotalPriceInPence));
   }
}
