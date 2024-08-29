package dp.knapsack01;

public class Q02_Knapsack_0_1_TopDown {
    static int[][] t; // [n][W]

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        int maxProfit = solveKnapsack(val, wt, W, n);
        System.out.println(maxProfit);
    }

    private static int solveKnapsack(int[] val, int[] wt, int W, int n) {
        t = new int[n + 1][W + 1];
        // inz t => fill first col and first row with 0
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) { // may consider
                    t[i][j] = Math.max(
                            // considering
                            val[i - 1] + t[i - 1][j - wt[i - 1]],
                            // not considering
                            t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        for (int i = 0 ; i <= n ; i ++) {
            for (int j = 0 ; j <= W ; j++) {
                System.out.print(t[i][j] + "  ");
            }
            System.out.println();
        }
        return t[n][W];
    }
}
