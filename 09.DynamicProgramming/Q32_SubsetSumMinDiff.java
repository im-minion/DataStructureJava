import java.util.Arrays;

/*
Partition a set into two subsets such that the difference of subset sums is minimum
Difficulty Level : Hard
Last Updated : 26 Oct, 2020
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements,
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
*/
public class Q32_SubsetSumMinDiff {
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int n = arr.length;

        // diff is in the range 0 to range
        System.out.println("solveByRecursive : " + solveByRecursiveTopDown(arr, n));
    }

    private static int solveByRecursiveTopDown(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
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

        // TODO: Important Below Thing
        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--) {
            // Find the
            if (t[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
}
