/*
18. Partition problem | DP-18
Difficulty Level : Medium

Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in
both subsets is the same.

Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false
The array cannot be partitioned into equal sum sets.
*/

import java.util.Arrays;

public class Q18_EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;
        boolean op = solveByRecursive(arr, n);
        System.out.println(op);
    }

    private static boolean solveByRecursive(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;//sum is odd
        int splitSum = sum / 2;

        return solveByRecursive(arr, splitSum, n);
    }

    private static boolean solveByRecursive(int[] arr, int sum, int n) {
        // base cond
        if (n == 0 && sum == 0) return true;
        if (n > 0 && sum == 0) return true;
        if (n == 0 && sum > 0) return false;

        //choice diagram
        if (arr[n - 1] <= sum) {
            // may or may not consider
            return
                    //consider
                    solveByRecursive(arr, sum - arr[n - 1], n - 1)
                            ||
                            // not consider
                            solveByRecursive(arr, sum, n - 1);
        } else {
            // can't consider
            return solveByRecursive(arr, sum, n - 1);
        }

    }
}
