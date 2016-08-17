package Chapter2;

/**
 * OrderedArray.java
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
                return nElems;
            } else {
                if(a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1
                }
            }
        }
    }
}
