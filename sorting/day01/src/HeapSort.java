public class HeapSort extends SortAlgorithm {
    private int size;
    private int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Recursively corrects the position of element indexed i: check children, and swap with larger child if necessary.
    private void heapify(int i) {
        // TODO
    }

    // Given the array, build a heap by correcting every non-leaf's position.
    private void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        // TODO
    }

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);
        for (int i=size-1; i>0; i--) {
            // TODO
        }
        return heap;
    }
}
