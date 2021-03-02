package rotations;

import java.util.HashSet;

public class PairWithSum {
    public static void main(String[] args) {
        int[] arr = {11, 15, 26, 38, 9, 10};
        // 8, 4, 7, 19, 10, 9
        System.out.println(isPairExists(arr, 28));
    }

    private static boolean isPairExists(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>(arr.length);
        for (int a : arr) {
            hashSet.add(sum - a);
        }
        for (int a : arr) {
            if (hashSet.contains(a)) return true;
        }
        return false;
    }
}
