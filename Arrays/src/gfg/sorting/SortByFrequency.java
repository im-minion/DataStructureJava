package gfg.sorting;

import java.util.*;

/*
Sort elements by frequency | Set 1
Difficulty Level : Medium

Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.

Examples:

Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
*/
public class SortByFrequency {
    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        doSorting(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    private static void doSorting(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer a : arr) {
            m.put(a, m.getOrDefault(a, 0) + 1);
        }

        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> h : m.entrySet()) {
            if (map.containsKey(h.getValue())) {
                List<Integer> temp = map.get(h.getValue());
                temp.add(h.getKey());
                map.put(h.getValue(), temp);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(h.getKey());
                map.put(h.getValue(), t);
            }
        }
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> iter : map.entrySet()) {
            Integer currCount = iter.getKey();
            List<Integer> currValue = iter.getValue();
            for (int val : currValue) {
                int i;
                for (i = 0; i < currCount; i++) {
                    arr[start] = val;
                    start++;
                }
            }
        }
    }
}
