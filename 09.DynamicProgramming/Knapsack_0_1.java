import java.util.Arrays;

public class Knapsack_0_1 {
    static int[][] t; // [n][W]

    public static void main(String[] args) {
        t = new int[500][1000];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        int[] val = {2, 4, 5, 7, 8, 7};
        int[] wt = {3, 6, 7, 9, 1, 3};
        int W = 25;
        int maxProfit = solveKnapsack(val, wt, W, val.length);
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
