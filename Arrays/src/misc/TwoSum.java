package misc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = { 2, 7, 8, 6 };

        int[] result = twoSum(array, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> valToIndexMap = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            Integer existingIndex = valToIndexMap.get(target - arr[i]);
            if (existingIndex == null) {
                valToIndexMap.put(arr[i], i);
            } else {
                result[0] = existingIndex;
                result[1] = i;
            }
        }
        return result;
    }

}