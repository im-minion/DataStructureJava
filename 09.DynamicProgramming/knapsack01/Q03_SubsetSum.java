package knapsack01;

/*
32. Subset Sum Problem | DP-25
Difficulty Level : Medium

Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Example:

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
*/
public class Q03_SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 30;

        System.out.println("isSubsetAvailRecursive :" + isSubsetAvailRecursive(arr, sum, arr.length));

        System.out.println("isSubsetAvail :" + isSubsetAvail(arr, sum, arr.length));
    }

    private static boolean isSubsetAvailRecursive(int[] arr, int sum, int n) {
        // base condition
        if (n == 0 && sum == 0) {
            return true;
        }
        if (n > 0 && sum == 0) {
            return true;
        }
        if (n == 0 && sum > 0) {
            return false;
        }

        // choice
        if (arr[n - 1] <= sum) {
            //may consider or may not
            return isSubsetAvailRecursive(arr, sum - arr[n - 1], n - 1) || isSubsetAvailRecursive(arr, sum, n - 1);
        } else {
            //not consider
            return isSubsetAvailRecursive(arr, sum, n - 1);
        }
    }

    private static boolean isSubsetAvail(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) t[i][j] = false;

                if (j == 0) t[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // we have choice to consider or not
                    t[i][j] =
                            //consider
                            (t[i - 1][j - arr[i - 1]]) ||
                                    //not consider
                                    (t[i - 1][j]);
                } else {
                    // can't consider
                    t[i][j] = t[i - 1][j];
                }
            }
        }


        return t[n][sum];
    }
}
