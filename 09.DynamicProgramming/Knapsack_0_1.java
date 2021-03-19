import java.util.Arrays;

/*
10. 0-1 Knapsack Problem | DP-10

Difficulty Level : Medium

Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item,
either pick the complete item or don’t pick it (0-1 property).
*/

public class Knapsack_0_1 {
    static int[][] t; // [n][W]

    public static void main(String[] args) {
        t = new int[500][1000];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        int maxProfit = solveKnapsack(val, wt, W, n);
        System.out.println(maxProfit);
    }

    private static int solveKnapsack(int[] val, int[] wt, int W, int n) {
        // boundary condition
        if (n == 0 || W == 0 || val.length == 0 || wt.length == 0) {
            return 0;
        }

        // memoization usage
        if (t[n][W] != -1) {
            return t[n][W];
        }

        // choice diagram
        if (W >= wt[n - 1]) {
            //consider
            t[n][W] = Math.max(val[n - 1] + solveKnapsack(val, wt, W - wt[n - 1], n - 1), solveKnapsack(val, wt, W, n - 1));
        } else {
            t[n][W] = solveKnapsack(val, wt, W, n - 1);
        }
        return t[n][W];
    }
}
