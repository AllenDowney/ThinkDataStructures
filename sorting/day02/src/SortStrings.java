public class SortStrings {

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for (int i = 0; i < stringLength; i++)
            CountingSort.countingSortByCharacter(S, i);
    }


}
