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

  public void insertRight(long value) throws RuntimeException {
    if (isFull()) {
      throw new RuntimeException();
    }
    size++;
    container[rear] = value;
    rear = incrementPosition(rear);
  }

  public void insertLeft(long value) {
    size++;
    container[++front] = value;
  }

  public int size() {
    return size;
  }

  public long removeLeft() {
    int temp = front;

    throwIfEmpty();

    size--;
    front = incrementPosition(front);
    return container[temp];
  }

  private int incrementPosition(int marker) {
    int check = marker + 1;
    if (check == maxSize) {
      check = 0;
    }
    return check;
  }

  private void throwIfEmpty() throws RuntimeException {
    if (isEmpty()) {
      throw new RuntimeException();
    }
  }

  public long removeRight() {
    throwIfEmpty();

    size--;
    rear = decrementPosition(rear);
    return container[rear];
  }

  public int decrementPosition(int marker) {
    int check = marker - 1;
    if (check == -1) {
      check = maxSize - 1;
    }

    return check;
  }

  public boolean isFull() {
    return size == maxSize;
  }
}
