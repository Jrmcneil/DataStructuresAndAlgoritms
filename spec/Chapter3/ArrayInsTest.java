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
  }

  //3.2
  @Test
  public void median() {
    assertEquals(55, arr.median());
  }

  //3.3
  @Test
  public void noDuplicates() {
    long[] temp = new long[100];

    arr.insertionSort();
    System.arraycopy(arr.getArray(), 0, temp, 0, arr.getArray().length);

    arr.insert(88);
    arr.insert(55);
    arr.insert(99);
    arr.insert(99);
    arr.insert(00);
    arr.insertionSort();
    arr.noDups();
    arr.display();
    assertArrayEquals(temp, arr.getArray());
  }
}