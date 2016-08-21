package Chapter4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesmcneil on 21/08/2016.
 */
public class DequeTest {

 Deque testDeque;

 @Before
 public void initialize() {
  testDeque = new Deque();
 }

 @Test
 public void isEmptyWhenEmpty() throws Exception {
   assertEquals(true, testDeque.isEmpty());
 }

 @Test
 public void isNotEmptyWhenNot() {
  testDeque.insert(11);

  assertEquals(false, testDeque.isEmpty());
 }

 @Test
 public void size() {
  assertEquals(0, testDeque.size());

  testDeque.insert(11);

  assertEquals(1, testDeque.size());
 }
}