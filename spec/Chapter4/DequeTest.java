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

 @Test
 public void removeWhenNotEmpty() {
  testDeque.insert(11);
  testDeque.insert(55);

  assertEquals(55, testDeque.remove());
  assertEquals(1, testDeque.size());
  assertEquals(11, testDeque.remove());
  assertEquals(0, testDeque.size());
 }
}