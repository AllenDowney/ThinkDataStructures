@SuppressWarnings("WrongPackageStatement")
class HeapSortSoln extends Sorter {
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

    private void heapify(int i) {
        int left = leftChild(i), right = rightChild(i);
        int largest;

        if (left < size && heap[left] > heap[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            exchange(largest, i);
            heapify(largest);
        }
    }

    private void exchange(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        int m = this.size / 2;

        for (int i=m; i>=0; i--) {
            heapify(i);
        }
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
