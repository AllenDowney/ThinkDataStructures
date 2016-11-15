package soln;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapProblems {

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        Map<Integer, Integer> countMap = new MyLinearMap<>();
        for (int i : arr) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        return countMap;
    }

    public static List<int[]> pairsThatAddTo(int[] arr, int k) {
        Map<Integer, Integer> countMap = getCountMap(arr);
        List<int[]> res = new ArrayList<>();
        for (int num1 : countMap.keySet()) {
            int num2 = k - num1;
            // Need 2 occurrences of a number if num2==num1, otherwise need 1 occurrence
            int requiredCount = (num1==num2) ? 2 : 1;
            int count1 = countMap.get(num1);
            int count2 = countMap.get(num2);
            while (count1 >= requiredCount && count2 >= requiredCount) {
                res.add(new int[]{num1, num2});
                count1--;
                count2--;
            }
            countMap.put(num1, count1);
            countMap.put(num2, count2);
        }
        return res;
    }

}
