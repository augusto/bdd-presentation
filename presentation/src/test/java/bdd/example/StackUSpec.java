package bdd.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class StackUSpec {

   private Stack<String> stack;

   @Before
   public void setup() {
      stack = new Stack<String>();
   }

   @Test
   public void can_push_and_pop_an_item() {
      stack.push("an item");

      assertThat(stack.pop(), equalTo("an item"));
   }

   @Test
   public void should_pop_items_in_reverse_order_as_pushed() {
      stack.push("first");
      stack.push("second");

      assertThat(stack.pop(), equalTo("second"));
      assertThat(stack.pop(), equalTo("first"));
   }

   @Test
   public void should_be_empty_when_created() {
      assertThat(stack.empty(), is(true));
   }

   @Test
   public void with_at_least_one_item_pushed_is_not_empty() {
      stack.push("just an item");

      assertThat(stack.empty(), is(false));
   }

   @Test
   public void with_all_items_popped_is_empty() {
      stack.push("an item");

      stack.pop();

      assertThat(stack.empty(), is(true));
   }

   @Test
   public void has_the_number_of_pushed_items() {
      stack.push("one");
      stack.push("two");
      stack.push("three");

      assertThat(stack.size(), equalTo(3));
   }

   @Test
   public void can_peek_at_the_first_element() {
      stack.push("first");
      stack.push("second");

      assertThat(stack.peek(), equalTo("second"));
   }

   @Test
   public void should_not_remove_an_item_() {
      stack.push("first");
      stack.push("second");

      assertThat(stack.peek(), equalTo("second"));
   }

   @Test(expected = EmptyStackException.class)
   public void throws_an_exception_when_pop_is_called_on_an_empty_stack() {
      stack.pop();
   }
}
