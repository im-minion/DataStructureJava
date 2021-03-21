/*
Cutting a Rod | DP-13
Difficulty Level : Medium


Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
For example, if length of the rod is 8 and the values of different pieces are given as following,
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/

import java.util.Arrays;
import java.util.stream.IntStream;

public class CuttingARod {
    static int[][] t_memo;

    public static void main(String[] args) {
        int[] priceArr = new int[]{1, 5, 8, 9, 10, 17, 17, 20}; // price should be max (val[])
        int[] lengthArr = IntStream.range(1, priceArr.length + 1).toArray(); // possibilities of lengths in which we can cut the rod (wt[])
        int n = priceArr.length;
        int totalLength = lengthArr.length;

        /*Recursive*/
        System.out.println("solveByRecursive        : " + solveByRecursive(priceArr, lengthArr, totalLength, n));

        /*Memoize*/
        t_memo = new int[n + 1][totalLength + 1];
        for (int[] row : t_memo) {
            Arrays.fill(row, -1);
        }
        System.out.println("solveByRecursiveMemoize : " + solveByRecursiveMemoize(priceArr, lengthArr, totalLength, n));

        /*Top Down*/
        System.out.println("solveByRecursiveTopDown : " + solveByRecursiveTopDown(priceArr, lengthArr, totalLength, n));
    }

    private static int solveByRecursiveTopDown(int[] priceArr, int[] lengthArr, int totalLength, int n) {
        int[][] t = new int[n + 1][totalLength + 1];
        // inz 1st row 1st col to 0
        // already inz to 0 non need to do anything

        //choice diagram
        for (int i = 1; i <= n; i++) { //
            for (int j = 1; j <= totalLength; j++) { // rod length size
                if (lengthArr[i - 1] <= j) {
                    // may or may not consider
                    t[i][j] = Math.max(
                            //consider
                            priceArr[i - 1] + t[i][j - lengthArr[i - 1]]
                            ,
                            //non-consider
                            t[i - 1][j]
                    );
                } else {
                    // can not consider
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][totalLength];
    }

    private static int solveByRecursiveMemoize(int[] priceArr, int[] lengthArr, int totalLength, int n) {

        // base cond
        if (n == 0) {
            return 0;
        }

        if (t_memo[n][totalLength] != -1) {
            return t_memo[n][totalLength];
        }

        // choice diagram
        if (lengthArr[n - 1] <= totalLength) { //may or may not consider
            return t_memo[n][totalLength] = Math.max(
                    // consider
                    priceArr[n - 1] + solveByRecursive(priceArr, lengthArr, totalLength - lengthArr[n - 1], n),
                    // not consider
                    solveByRecursive(priceArr, lengthArr, totalLength, n - 1)
            );
        } else {
            return t_memo[n][totalLength] = solveByRecursive(priceArr, lengthArr, totalLength, n - 1);
        }
    }

    private static int solveByRecursive(int[] priceArr, int[] lengthArr, int totalLength, int n) {
        // base cond
        if (n == 0) {
            return 0;
        }

        // choice diagram
        if (lengthArr[n - 1] <= totalLength) { //may or may not consider
            return Math.max(
                    // consider
                    priceArr[n - 1] + solveByRecursive(priceArr, lengthArr, totalLength - lengthArr[n - 1], n),
                    // not consider
                    solveByRecursive(priceArr, lengthArr, totalLength, n - 1)
            );
        } else {
            return solveByRecursive(priceArr, lengthArr, totalLength, n - 1);
        }
    }
}
