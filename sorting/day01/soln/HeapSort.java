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

    private void sink(int i) {
        int left = leftChild(i), right = rightChild(i);

        // select largest element from indices i, left, and right
        int largest = i;
        if (left < size && heap[left] > heap[i]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            swap(heap, largest, i);
            sink(largest);
        }
    }

    private void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        int m = this.size / 2;

        for (int i=m; i>=0; i--) {
            sink(i);
        }
    }

    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);

        for (int i=size-1; i>0; i--) {
            swap(heap, i, 0);
            size--;
            sink(0);
        }

        return heap;
    }
}
