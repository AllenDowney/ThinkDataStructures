import java.util.Arrays;

public abstract class Sorter {

    public Sorter() {}

    public abstract int[] sort(int[] array);

    public static void main(String[] args) {
        Sorter sorter = new MergeSort();
        System.out.println(Arrays.toString(sorter.sort(new int[]{5,4,3,2,1})));
    }
}
