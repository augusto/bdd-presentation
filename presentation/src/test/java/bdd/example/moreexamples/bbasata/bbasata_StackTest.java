package bdd.example.moreexamples.bbasata;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Taken from https://gist.github.com/1340977
 * Writen by github user bbasata - https://github.com/bbasata
 */
public class bbasata_StackTest {
   Stack<String> stack = new Stack<String>();

   @Test
   public void
   isInitiallyEmpty() {
      assertThat(stack.isEmpty(), is(true));
   }

   @Test(expected = EmptyStackException.class)
   public void
   refusesToPopWhenItIsEmpty() {
      stack.pop();
   }

   @Test
   public void
   isNotEmptyWhenItHasAnItem() {
      stack.push("an item");
      assertThat(stack.isEmpty(), is(false));
   }

   @Test
   public void
   popsAnItem() {
      stack.push("first item");

      String poppedItem = stack.pop();
      assertThat(poppedItem, is("first item"));
   }

   @Test
   public void
   removesAnItemWhenItIsPopped() {
      stack.push("first item");

      stack.pop();
      assertThat(stack.isEmpty(), is(true));
   }
}
