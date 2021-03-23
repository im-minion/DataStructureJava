package knapsack01;

import java.util.Arrays;

public class Q07_SubsetSumKDiffCount {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int n = arr.length;
        System.out.println(getCountOfSubsetsWithDiff(arr, n, diff));
    }

    private static int getCountOfSubsetsWithDiff(int[] arr, int n, int diff) {
        int sum = Arrays.stream(arr).sum();
        int subSetSum = (sum + diff) / 2;

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
