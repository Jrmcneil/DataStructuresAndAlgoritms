package Chapter4;

/**
 * Class for Deque (double ended queue)
 */
public class Deque {

  private int size = 0;

  public boolean isEmpty() {
    return size > 0;
  }

  public void insert(long value) {
    size++;
  }

  public int size() {
    return size;
  }
}
