package dp.lcs;

import java.util.Arrays;

/*
Longest Palindromic Subsequence | DP-12
Difficulty Level : Medium

Given a sequence, find the length of the longest palindromic subsequence in it.

As another example,
if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subsequence in it.
“BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
The naive solution for this problem is to generate all subsequences of the given sequence and find the longest palindromic subsequence.
This solution is exponential in term of time complexity.
Let us see how this problem possesses both important properties of a Dynamic Programming (DP) Problem
and can efficiently be solved using Dynamic Programming.
*/
public class Q18_LongestPalindromicSubsequence {

    static int[][] t;

    public static void main(String[] args) {
        String seq = "BBABCBCAB";
        System.out.println("The length of the LPS is " + lps(seq));
        System.out.println("The length of the LPS by lpsByRec is " + lpsByRec(seq));

    }

    private static int lpsByRec(String X) {
        String Y = new StringBuilder(X).reverse().toString();
        t = new int[X.length() + 1][Y.length() + 1];
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        return lpsRecSolve(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
    }

    private static int lpsRecSolve(char[] X, char[] Y, int m, int n) {
        if (X.length == 0 || Y.length == 0 || m == 0 || n == 0) {
            return 0;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (X[m - 1] == Y[n - 1]) {
            t[m][n] = 1 + lpsRecSolve(X, Y, m - 1, n - 1);
        } else {
            t[m][n] = Math.max(lpsRecSolve(X, Y, m - 1, n), lpsRecSolve(X, Y, m, n - 1));
        }
        return t[m][n];

    }

    private static int lps(String s) {
        int m = s.length();
        int n = s.length();
        char[] x = s.toCharArray();
        char[] y = new StringBuilder(s).reverse().toString().toCharArray();
        int[][] t = new int[m + 1][n + 1];
        // choice diagram
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) { //can consider
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else { // can't consider
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
                }
            }
        }
        return t[m][n];
    }
}
