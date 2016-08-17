package Chapter2;

/**
 * OrdArray.java
 * demonstrates ordered array class
 */
public class OrdArray {
  private long[] a;
  private int nElems;

  public OrdArray(int max) {
    a = new long[max];
    nElems = 0;
  }

  public int size() {
    return nElems;
  }

  public int find(long searchKey) {
    int lowerBound = 0;
    int upperBound = nElems - 1;
    int curIn;

    while(true) {
      curIn = (lowerBound + upperBound) / 2;
      if(a[curIn] == searchKey) {
        return curIn;
      } else if(lowerBound > upperBound) {
        return -1;
      } else {
        if(a[curIn] < searchKey) {
          lowerBound = curIn + 1;
        } else {
          upperBound = curIn - 1;
        }
      }
    }
  }

  public void insert(long value) {
    int j;

    j = searchHalves(nElems, 0, value);

    for(int k=nElems; k>j; k--) {
      a[k] = a[k - 1];
    }

    a[j] = value;

    nElems++;
  }

  private int searchHalves(int upperBound, int lowerBound, long value) {
    int position = (upperBound + lowerBound) / 2;

    if (upperBound == position) {
      return position;
    }

    if (a[position] < value) {
      return searchHalves(upperBound, position + 1, value);
    } else {
      return searchHalves(position, lowerBound, value);
    }
  }

  public boolean delete(long value) {
    int j = find(value);
    if(j == nElems) {
      return false;
    } else {
      for(int k = j; k < nElems; k++) {
        a[k] = a[k + 1];
      }

      nElems--;
      return true;
    }
  }

  public void display() {
    for(int j = 0; j < nElems; j++) {
      System.out.print(a[j] + " ");
    }

    System.out.println(" ");
  }
}
