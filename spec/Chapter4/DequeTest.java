package Chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesmcneil on 21/08/2016.
 */
public class DequeTest {

 @Test
 public void isEmpty() throws Exception {
   Deque testDeque = new Deque();

   assertEquals(true, testDeque.isEmpty());
 }
}