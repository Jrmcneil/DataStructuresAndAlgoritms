package Chapter2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesmcneil on 17/08/2016.
 */
public class OrdArrayTest {

  OrdArray testArrayOne;

  @Before
  public void initialize() {
    testArrayOne = new OrdArray(30);
    assertEquals(testArrayOne.size(), 0);

    testArrayOne.insert(55);
    testArrayOne.insert(33);
    testArrayOne.insert(11);
    testArrayOne.insert(22);
    testArrayOne.insert(77);
    testArrayOne.insert(66);
  }

  //2.4
  @Test
  public void insert() {
    assertEquals(testArrayOne.size(), 6);
  }

  @Test
  public void find() {
    assertEquals(testArrayOne.find(22), 1);
    assertEquals(testArrayOne.find(55), 3);
  }

  @Test
  public void delete() {
    testArrayOne.delete(22);

    assertEquals(testArrayOne.find(22), -1);
    assertEquals(testArrayOne.size(), 5);
    assertEquals(testArrayOne.find(33), 1);
  }

  //2.5
  @Test
  public void merge() {
    OrdArray testArrayTwo = new OrdArray(30);

    testArrayTwo.insert(3);
    testArrayTwo.insert(56);
    testArrayTwo.insert(66);
    testArrayTwo.insert(129);

    testArrayOne.merge(testArrayTwo);

    assertEquals(testArrayOne.size(), 10);
    assertEquals(testArrayOne.find(3), 0);
    assertEquals(testArrayOne.find(129), 9);
    assertEquals(testArrayOne.find(56), 5);
  }
}