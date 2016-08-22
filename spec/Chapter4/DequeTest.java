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
   testDeque.insertRight(11);

   assertEquals(false, testDeque.isEmpty());
 }

 @Test
 public void size() {
   assertEquals(0, testDeque.size());

   testDeque.insertRight(11);

   assertEquals(1, testDeque.size());
 }

 @Test
 public void removeLeftWhenNotEmpty() {
   testDeque.insertRight(11);
   testDeque.insertRight(55);

   assertEquals(11, testDeque.removeLeft());
   assertEquals(1, testDeque.size());
   assertEquals(55, testDeque.removeLeft());
   assertEquals(0, testDeque.size());
 }


 @Test
 public void insertRightingBeyondMaxSizeWrapsValues() {
   testDeque.insertRight(11);
   testDeque.insertRight(44);
   testDeque.insertRight(55);
   testDeque.insertRight(66);
   testDeque.insertRight(77);
   testDeque.removeLeft();
   testDeque.insertRight(22);

   assertEquals(44, testDeque.removeLeft());
   assertEquals(55, testDeque.removeLeft());
   assertEquals(66, testDeque.removeLeft());
   assertEquals(77, testDeque.removeLeft());
   assertEquals(22, testDeque.removeLeft());
 }

  @Test
  public void exceptionThrownIfFull() {
    testDeque.insertRight(11);
    testDeque.insertRight(11);
    testDeque.insertRight(11);
    testDeque.insertRight(11);
    testDeque.insertRight(11);

    thrown.expect(Exception.class);
    testDeque.insertRight(11);
  }


  @Test
  public void isFull() {
    assertEquals(false, testDeque.isFull());
    testDeque.insertRight(11);
    testDeque.insertRight(11);
    testDeque.insertRight(11);
    testDeque.insertRight(11);
    testDeque.insertRight(11);

    assertEquals(true, testDeque.isFull());
  }

  @Test
  public void removeRight() {
    testDeque.insertRight(11);
    testDeque.insertRight(22);

    assertEquals(22, testDeque.removeRight());
  }

  @Test
  public void removeRightIfWrapped() {
    testDeque.insertRight(11);
    testDeque.insertRight(44);
    testDeque.insertRight(55);
    testDeque.insertRight(66);
    testDeque.insertRight(77);
    testDeque.removeLeft();
    testDeque.insertRight(22);

    assertEquals(22, testDeque.removeRight());
  }
}