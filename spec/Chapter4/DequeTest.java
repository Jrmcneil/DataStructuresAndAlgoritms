package Chapter4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.notification.RunListener;

import static org.junit.Assert.*;

/**
 * Created by jamesmcneil on 21/08/2016.
 */
public class DequeTest {

 Deque testDeque;

 private final int CONTAINER_SIZE = 5;

 @Rule
 public ExpectedException thrown = ExpectedException.none();

 @Before
 public void initialize() {
   testDeque = new Deque(CONTAINER_SIZE);
 }

 @Test
 public void isEmptyWhenEmpty() throws Exception {
   assertEquals(true, testDeque.isEmpty());
 }

 @Test
 public void isNotEmptyWhenNot() {
   testDeque.insertLeft(11);

   assertEquals(false, testDeque.isEmpty());
 }

 @Test
 public void size() {
   assertEquals(0, testDeque.size());

   testDeque.insertLeft(11);

   assertEquals(1, testDeque.size());
 }

 @Test
 public void removeWhenNotEmpty() {
   testDeque.insertLeft(11);
   testDeque.insertLeft(55);

   assertEquals(11, testDeque.remove());
   assertEquals(1, testDeque.size());
   assertEquals(55, testDeque.remove());
   assertEquals(0, testDeque.size());
 }


 @Test
 public void insertLeftingBeyondMaxSizeWrapsValues() {
   testDeque.insertLeft(11);
   testDeque.insertLeft(44);
   testDeque.insertLeft(55);
   testDeque.insertLeft(66);
   testDeque.insertLeft(77);
   testDeque.remove();
   testDeque.insertLeft(22);

   assertEquals(44, testDeque.remove());
   assertEquals(55, testDeque.remove());
   assertEquals(66, testDeque.remove());
   assertEquals(77, testDeque.remove());
   assertEquals(22, testDeque.remove());
 }

  @Test
  public void exceptionThrownIfFull() {
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);

    thrown.expect(Exception.class);
    testDeque.insertLeft(11);
  }


  @Test
  public void isFull() {
    assertEquals(false, testDeque.isFull());
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);
    testDeque.insertLeft(11);

    assertEquals(true, testDeque.isFull());
  }
}