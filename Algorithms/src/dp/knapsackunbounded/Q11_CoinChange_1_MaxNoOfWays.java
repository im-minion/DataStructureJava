package dp.knapsackunbounded;/*
Coin Change | DP-7
Difficulty Level : Hard

Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

*/


public class Q11_CoinChange_1_MaxNoOfWays {

    static int t[][];

    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int n = coin.length;
        int sum = 4;
        t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println("solveByTopDown : " + solveByTopDown(coin, sum, n));
        System.out.println("solveByRecursiveMemo : " + solveByRecursiveMemo(coin, sum, n));
    }

    private static int solveByRecursiveMemo(int[] coin, int sum, int n) {
        if (n == 0 && sum > 0) return 0;
        if (n == 0 && sum == 0) return 1;
        if (n > 0 && sum == 0) return 1;

        if (t[n][sum] != -1) {
            return t[n][sum];
        }

        if (coin[n - 1] <= sum) {
            t[n][sum] = solveByRecursiveMemo(coin, sum - coin[n - 1], n) +
                    solveByRecursiveMemo(coin, sum, n - 1);
        } else {
            t[n][sum] = solveByRecursiveMemo(coin, sum, n - 1);
        }

        return t[n][sum];

    }

    private static int solveByTopDown(int[] coin, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];

        // inz
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // flow diag
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coin[i - 1] <= j) { //may consider or not
                    // consider + not_consider
                    t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
                } else {
                    // can't consider
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
