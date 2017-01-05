public class HeapSort extends Sorter {
    private int size;
    private int[] heap;

    private int parent(int i) {
                            return (i-1) / 2;
                                             }

    private int leftChild(int i) {
                               return 2*i + 1;
                                              }

    private int rightChild(int i) {
                                return 2*(i + 1);
                                                 }

    /**
     * Recursively corrects the position of element indexed i: check children, and swap with larger children if necessary.
     * @param i
     */
    private void heapify(int i) {
        // TODO: Complete this method
    }

    private void exchange(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Given the array, build a heap by correcting every non-leaf's position.
     * @param array
     */
    private void buildHeapFrom(int[] array) {
        // TODO: Complete this method
    }

    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);

        for (int i=size-1; i>0; i--) {
            exchange(i, 0);
            size--;
            heapify(0);
        }

        return heap;
    }
}
