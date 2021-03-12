package rangequeries;
/*
Constant time range add operation on an array
Difficulty Level : Medium

Given an array of size N which is initialized with all zeros.
We are given many ranges add queries, which should be applied to this array.
We need to print the final updated array as our result.

Examples:

N = 6
Arr = [0, 0, 0, 0, 0, 0]
rangeUpdate1 [0, 2], add 100
Arr = [100, 100, 100, 0, 0, 0]
rangeUpdate1 [1, 5], add 100
Arr = [100, 200, 200, 100, 100, 100]
rangeUpdate1 [2, 3], add 100
Arr = [100, 200, 300, 200, 100, 100]
Which is the final updated array.
*/

import java.util.Arrays;

public class RangeQueriesAddOperation {
    public static void main(String[] args) {
        int N = 6;

        int[] arr = new int[N];

        // Range add Queries
        add(arr, N, 0, 2, 100);
        add(arr, N, 1, 5, 100);
        add(arr, N, 2, 3, 100);
        System.out.println("Approach 1:");
        Arrays.stream(arr).forEach(el -> System.out.print(el + " "));

        System.out.println("\n*******************************");

        int N2 = 6;

        int[] arr2 = new int[N];

        // Range add Queries
        addUsingPrefixSumTechnique(arr2, N2, 0, 2, 100);
        addUsingPrefixSumTechnique(arr2, N2, 1, 5, 100);
        addUsingPrefixSumTechnique(arr2, N2, 2, 3, 100);
        updateArray(arr2, N2);
        System.out.println("Approach 2:");
        Arrays.stream(arr2).forEach(el -> System.out.print(el + " "));
    }

    private static void updateArray(int[] arr2, int n2) {
        for (int i = 1; i < n2; i++) {
            arr2[i] += arr2[i - 1];
        }
    }

    private static void addUsingPrefixSumTechnique(int[] arr, int n, int low, int high, int addValue) {
        // boundary condition
        if (low < 0 || low >= n || high >= n || high < 0 || addValue == 0) return;
        arr[low] += addValue;
        if (high != n - 1)
            arr[high + 1] -= addValue;
    }

    private static void add(int[] arr, int n, int low, int high, int addValue) {
        // boundary condition
        if (low < 0 || low >= n || high >= n || high < 0 || addValue == 0) return;
        while (low <= high) {
            if (low != high) {
                arr[high] += addValue;
                high--;
            }
            arr[low] += addValue;
            low++;

        }
    }
}
