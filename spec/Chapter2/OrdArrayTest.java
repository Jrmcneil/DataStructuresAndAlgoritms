package Chapter2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesmcneil on 17/08/2016.
 */
public class OrdArrayTest {

  OrdArray testArray;

  @Before
  public void initialize() {
    testArray = new OrdArray(10);
    assertEquals(testArray.size(), 0);

    testArray.insert(55);
    testArray.insert(33);
    testArray.insert(11);
    testArray.insert(22);
    testArray.insert(77);
    testArray.insert(66);
  }

  //2.4
  @Test
  public void insert() {
    assertEquals(testArray.size(), 6);
  }

  @Test
  public void find() {
    assertEquals(testArray.find(22), 1);
    assertEquals(testArray.find(55), 3);
  }

  @Test
  public void delete() {
    testArray.delete(22);

    assertEquals(testArray.find(22), -1);
    assertEquals(testArray.size(), 5);
    assertEquals(testArray.find(33), 1);
  }
}