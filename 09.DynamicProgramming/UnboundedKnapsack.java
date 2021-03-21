/*
Unbounded Knapsack (Repetition of items allowed)
Difficulty Level : Medium

Given a knapsack weight W and a set of n items with certain value vali and weight wti,
we need to calculate the maximum amount that could make up this quantity exactly.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
Examples:

Input : W = 100
val[]  = {1, 30}
wt[] = {1, 50}
Output : 100
There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
instances of 1 unit weight items.
We get maximum value with option 2.

Input : W = 8
val[] = {10, 40, 50, 70}
wt[]  = {1, 3, 4, 5}
Output : 110
We get maximum value with one unit of
weight 5 and one unit of weight 3.
*/

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int W = 100;
        int[] val = {10, 30, 20};
        int[] wt = {5, 10, 15};
        int n = val.length;
        System.out.println(unboundedKnapsack(val, wt, W, n));
    }

    private static int unboundedKnapsack(int[] val, int[] wt, int W, int n) {
        int[][] t = new int[n + 1][W + 1];
        // inz needed 1st row and 1st col to 0,
        // already 0


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) { //may or may not consider
                    t[i][j] =
                            // max (consider, not-consider)
                            Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
                } else { // can't consider
                    t[i][j] = t[i - 1][j];
                }
            }
        }


        return t[n][W];
    }

}
