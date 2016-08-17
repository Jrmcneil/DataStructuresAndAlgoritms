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
    assertEquals(0, testArrayOne.size());

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
    assertEquals(6, testArrayOne.size());
  }

  @Test
  public void find() {
    assertEquals(1, testArrayOne.find(22));
    assertEquals(3, testArrayOne.find(55));
  }

  @Test
  public void delete() {
    testArrayOne.delete(22);

    assertEquals(-1, testArrayOne.find(22));
    assertEquals(5, testArrayOne.size());
    assertEquals(1, testArrayOne.find(33));
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

    assertEquals(10, testArrayOne.size());
    assertEquals(0, testArrayOne.find(3));
    assertEquals(9, testArrayOne.find(129));
    assertEquals(5, testArrayOne.find(56));
  }
}