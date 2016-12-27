/*************************************************************************
 *  Compilation:  javac MinPQ.java
 *  Execution:    java MinPQ
 *  
 *  Generic min priority queue implementation with a binary heap.
 *
 *  % java MinPQ
 *  a
 *  is
 *  test
 *  this
 *
 *  This code is adapted from Chapter 9 in "Algorithms in Java", Third
 *  Edition, by Robert Sedgewick, Addison-Wesley, 2004.
 *
 *  The amortized performance guarantee is O(log N) per operation. It
 *  is only an amortized guarantee (and not a worst-case) because of
 *  the repeated doubling operation.
 *
 *************************************************************************/

public class MinPQ<Item extends Comparable<Item>> {
    private Item[] pq;     // store element at indices 1 to N
    private int N;         // number of elements on priority queue

    // set inititial capacity of heap to hold given number of elements
    public MinPQ(int maxN) {
        pq = (Item[]) new Comparable[maxN + 1];
        N = 0;
    }

    // set inititial capacity of heap to hold 0 elements
    public MinPQ() { this(0); }

    public boolean isEmpty() { return N == 0;  }   // is the PQ empty?
    public int size()        { return N;       }   // # elements on PQ
    public Item min()        { return pq[1];   }   // smallest element

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Comparable[capacity];
        for (int i = 0; i <= N; i++) temp[i] = pq[i];
        pq = temp;
    }

    // add a new element to the priority queue
    public void insert(Item x) {

        // double size of array if necessary
        if (N >= pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++N] = x;
        swim(N);
    }

    // delete and return the minimum element, restoring the heap-order invariant
    public Item delMin() {
        if (N == 0) throw new RuntimeException("Priority queue underflow");
        exch(1, N);
        Item min = pq[N--];
        sink(1);
        pq[N + 1] = null;         // to help with garbage collection
        return min;
    }


   /***********************************************************************
    * Helper functions to restore the heap invariant.
    **********************************************************************/

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

   /***********************************************************************
    * Helper functions for comparisons and swaps.
    **********************************************************************/
    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Item swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


   /***********************************************************************
    * Test routine.
    **********************************************************************/
    public static void main(String[] args) {
        MinPQ<String> pq = new MinPQ<String>();
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty())
            System.out.println(pq.delMin());
    }

}
