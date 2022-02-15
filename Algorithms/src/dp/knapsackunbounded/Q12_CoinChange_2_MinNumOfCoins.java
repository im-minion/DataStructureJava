package dp.knapsackunbounded;

import java.util.Arrays;

/*
Find minimum number of coins that make a given value
Difficulty Level : Medium
Last Updated : 16 Feb, 2021

Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
what is the minimum number of coins to make the change? If it’s not possible to make change, print -1.

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents

*/
public class Q12_CoinChange_2_MinNumOfCoins {
    static int[][] dp;

    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        int sum = 30;
        int n = coins.length;
        int minCoins = solveByTopDown(coins, sum, coins.length);
        dp = new int[sum + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("solveByRecursive : " + solveByRecursive(coins, sum, coins.length, 0));
        System.out.println("solveByTopDown : " + minCoins);
    }

    private static int solveByTopDown(int[] coins, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        // inz =>
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[i][j] = 0;
                }
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }

                // only second row
                if (i == 1 && j >= 1) {
                    if (j % coins[0] == 0) {
                        t[i][j] = j / coins[0];
                    } else {
                        t[i][j] = Integer.MAX_VALUE - 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) { //may or may not consider
                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                } else {
                    // can't consider
                    t[i][j] = t[i - 1][j];
                }
            }

        }
        return t[n][sum];
    }

    static int solveByRecursive(int a[], int target, int n, int count) {
        if (target == 0) return count;
        if (n == 0) return Integer.MAX_VALUE;
        if (dp[target][n] != -1) return dp[target][n];

        if (target >= a[n - 1]) { // may or may not consider
            return dp[target][n] = Math.min(solveByRecursive(a, target - a[n - 1], n, count + 1),
                    solveByRecursive(a, target, n - 1, count));
        }
        return dp[target][n] = solveByRecursive(a, target, n - 1, count);
    }
}
