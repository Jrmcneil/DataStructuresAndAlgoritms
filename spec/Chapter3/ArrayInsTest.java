package Chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for insertion sort class
 */
public class ArrayInsTest {

  private ArrayIns arr;

  @Before
  public void initialize() {
    int maxSize = 100;

    arr = new ArrayIns(maxSize);

    arr.insert(77);
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(00);
    arr.insert(11);
    arr.insert(66);
    arr.insert(33);

    arr.display();

    arr.insertionSort();

    arr.display();
  }

  @Test
  public void median() {
    assertEquals(44, arr.median());
  }
}