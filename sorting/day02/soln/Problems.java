public class Problems {

    static void sortNumsUnder100(int[] A) {
        CountingSort.countingSort(A, 100);
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for (int i = 0; i < stringLength; i++)
            CountingSort.countingSortByCharacter(S, i);
    }

}
