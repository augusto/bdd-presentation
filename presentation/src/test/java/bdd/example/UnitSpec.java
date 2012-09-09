package bdd.example;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UnitSpec {

   @Test
   public void outline(){
      //given

      //when

      //then
   }

   @Test
   public void can_tokenise_sentence(){
      //given
      String sentence = "The quick brown fox jumps over the lazy dog";
      String expectedWords[] = {"The","quick","brown","fox","jumps","over","the","lazy","dog"};

      //when
      String[] tokens = sentence.split(" ");

      //then
      assertThat(tokens, equalTo(expectedWords));
   }
}
