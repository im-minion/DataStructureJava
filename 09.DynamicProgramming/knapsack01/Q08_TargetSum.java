package knapsack01;

import java.util.Arrays;

/*
Leet Code
494. Target Sum
Medium
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
This problem is same as Q32_SubsetSumMinDiff
*/
public class Q08_TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int s = 3;
        int n = arr.length;
        System.out.println(getCountOfSignArrangement(arr, s, n));
    }

    private static int getCountOfSignArrangement(int[] arr, int s, int n) {
        int arrSum = Arrays.stream(arr).sum();
        int subSetSum = (arrSum + s) / 2;
        return getSubsetSumCount(arr, n, subSetSum);
    }

    private static int getSubsetSumCount(int[] arr, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) { //may or may not consider
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else { // not considering
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }
}
