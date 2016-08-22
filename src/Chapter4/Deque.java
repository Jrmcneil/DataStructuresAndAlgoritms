package Chapter4;

import java.awt.*;
import java.util.Arrays;

/**
 * Class for Deque (double ended queue)
 */
public class Deque {

  private int size;
  private int front;
  private int rear;
  private int maxSize;
  private long[] container;

  public Deque(int containerSize) {
    size = 0;
    front = 0;
    rear = 0;
    maxSize = containerSize;
    container = new long[maxSize];
  }


  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(long value) {
    size++;
    int temp = rear;
    rear++;
    if (rear == maxSize) {
      rear = 0;
    }
    container[temp] = value;
  }

  public int size() {
    return size;
  }

  public long remove() {
    size--;
    int temp = front;
    front++;
    if (front == maxSize) {
      front = 0;
    }
    return container[temp];
  }


}
