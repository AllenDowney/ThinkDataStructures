public abstract class Sorter {

    public Sorter() {}

    public abstract int[] sort(int[] array);

    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.printf("]\n");
    }

    public static void main(String[] args) {
        Sorter sorter = new MergeSort();

        sorter.printArray(sorter.sort(new int[]{5,4,3,2,1}));
    }
}
