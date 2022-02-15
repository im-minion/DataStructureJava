package gfg.searching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayTwoSum {
    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8, 8};
        int n = 16;
        List<Integer> op = getPairs(A, n);
        System.out.println(op);
    }

    private static List<Integer> getPairs(int[] arr, int sum) {
        List<Integer> op = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = sum - arr[i];
            if (hashSet.contains(curr)) {
                op.add(arr[i]);
                op.add(curr);
            }
            hashSet.add(arr[i]);
        }
        return op;
    }
}
