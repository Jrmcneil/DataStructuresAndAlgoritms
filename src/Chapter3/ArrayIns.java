package Chapter3;

/**
 *emonstrates insertion sort
 */
public class ArrayIns {
  private long[] a;
  private int nElems;

  public ArrayIns(int max) {
    a = new long[max];
    nElems = 0;
  }

  public void insert(long value) {
    a[nElems] = value;
    nElems++;
  }

  public void insertionSort() {
    int in, out;

    for (out = 1; out < nElems; out++) {
      long temp = a[out];
      in = out;

      while (in > 0 && a[in - 1] >= temp) {
        a[in] = a[in - 1];
        --in;
      }

      a[in] = temp;
    }
  }

  public long[] getArray() {
    return a;
  }

  public long median() {
    this.insertionSort();
    return a[nElems / 2];
  }

  public void display() {
    for (int j = 0; j < nElems; j++) {
      System.out.print(a[j] + " ");
    }
    System.out.println(" ");
  }

  public void noDups() {
    int tempElems = nElems;

    long currentValue = -1;
    int shift = 0;

    for(int j = 0; j <  tempElems; j++) {

      if(a[j] == currentValue) {
        shift++;
        nElems--;
      } else {
        currentValue = a[j];
        a[j - shift] = a[j];
      }

    }

    for(int i = nElems; i < tempElems; i++) {
      a[i] = 0;
    }
  }
}
