package gfg.rotations;

import java.util.HashSet;

public class CountTriplet {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2};
        System.out.println(countTriplet(arr, arr.length));
    }

    public static int countTriplet(int[] arr, int n) {
        int result = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int a : arr) {
            hashSet.add(a);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hashSet.contains(arr[i] + arr[j])) {
                    result++;
                }
            }
        }
        return result;
    }
}
