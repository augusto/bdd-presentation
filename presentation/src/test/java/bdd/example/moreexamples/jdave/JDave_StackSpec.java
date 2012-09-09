package bdd.example.moreexamples.jdave;
import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;
import org.junit.runner.RunWith;

import java.util.Stack;

@RunWith(JDaveRunner.class)
public class JDave_StackSpec extends Specification<Stack<?>> {

   public class EmptyStack {
      private Stack<String> stack;

      public Stack<String> create() {
         stack = new Stack<String>();
         return stack;
      }

      public void isEmpty() {
         specify(stack, must.be.empty());
      }

      public void isNoLongerEmptyAfterPush() {
         stack.push("anything");
         specify(stack, must.not().be.empty());
      }
   }

   public class StackWhichIsNotEmpty {
      private Stack<Integer> stack;

      public Stack<Integer> create() {
         stack = new Stack<Integer>();
         for (int i = 0; i < 10; i++) {
            stack.push(i);
         }
         return stack;
      }

      public void addsToTheTopWhenSentPush() {
         stack.push(100);
         specify(stack.peek(), must.equal(100));
      }
   }

      /** Specifications for a bounded stack. The java.util.Stack is an unbounded implementation
      public class FullStack {
         private Stack<Integer> stack;

         public Stack<Integer> create() {
            stack = new Stack<Integer>(10);
            for (int i = 0; i < 10; i++) {
               stack.push(i);
            }
            return stack;
         }

         public void isFull() {
            specify(stack, must.be.full());
         }

         public void complainsOnPush() {
            specify(new Block() {
               public void run() throws Throwable {
                  stack.push(100);
               }
            }, should.raise(StackOverflowException.class));
         }

         public void containsAllItems() {
            for (int i = 0; i < 10; i++) {
               specify(stack, contains(i));
            }
         }

         public void doesNotContainRemovedItem() {
            stack.remove(3);
            specify(stack, does.not().contain(3));
         }

         public void containsAllButRemovedItem() {
            stack.remove(3);
            specify(stack, containsExactly(0, 1, 2, 4, 5, 6, 7, 8, 9));
         }
      }
      **/
}
