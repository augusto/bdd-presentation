package bdd.example;

import junit.framework.TestCase;

import java.util.EmptyStackException;
import java.util.Stack;

/** Unit tests as they were written in the 70' **/
public class StackTestAsZiggyStardustWouldHaveWrittenItTest extends TestCase {

   Stack<Object> stack;

   public void setUp() {
      stack = new Stack<Object>();
   }

   public void testPop1() {
      Object item = new Object();
      stack.push(item);

      assertEquals(item, stack.pop());
   }

   public void testPop3() {

      Object first = new Object();
      Object second = new Object();
      stack.push(first);
      stack.push(second);

      assertEquals(second, stack.pop());
      assertEquals(first, stack.pop());
   }

   public void testPop2() {

      try {
         stack.pop();
         fail();
      } catch (EmptyStackException ese) {
         //expected
      }
   }

   public void testEmpty1() {
      assertTrue(stack.empty());
   }

   public void testEmpty2() {
      stack.push(new Object());

      assertFalse(stack.empty());
   }

   public void testEmpty3() {
      stack.push(new Object());
      stack.pop();

      assertTrue(stack.empty());
   }


}
