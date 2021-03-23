package knapsackunbounded;

import java.util.Arrays;

/*
Longest Common Subsequence | DP-4
Difficulty Level : Medium
We have discussed Overlapping Subproblems and Optimal Substructure properties in Set 1 and Set 2 respectively.
We also discussed one example problem in Set 3.
Let us discuss Longest Common Subsequence (LCS) problem as one more example problem that can be solved using Dynamic Programming.

LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

In order to find out the complexity of brute force approach,
we need to first know the number of possible different subsequences of a string with length n, i.e.,
find the number of subsequences with lengths ranging from 1,2,..n-1.
Recall from theory of permutation and combination that number of combinations with 1 element are nC1.
Number of combinations with 2 elements are nC2 and so forth and so on. We know that nC0 + nC1 + nC2 + … nCn = 2n.
So a string of length n has 2n-1 different possible subsequences since we do not consider the subsequence with length 0.
This implies that the time complexity of the brute force approach will be O(n * 2n).
Note that it takes O(n) time to check if a subsequence is common to both the strings.
This time complexity can be improved using dynamic programming.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files),
and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/
public class Q13_LongestCommonSubsequence {
    public static int[][] t_memo;

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length lengthOfLongestCommonSubsequenceRecursive : " + lengthOfLongestCommonSubsequenceRecursive(X, Y, m, n));

        t_memo = new int[m + 1][n + 1];
        for (int[] row : t_memo) {
            Arrays.fill(row, -1);
        }
        System.out.println("Length lengthOfLongestCommonSubsequenceMemoize   : " + lengthOfLongestCommonSubsequenceMemoize(X, Y, m, n));

        System.out.println("Length lengthOfLongestCommonSubsequenceTopDown   : " + lengthOfLongestCommonSubsequenceTopDown(X, Y, m, n));
    }

    private static int lengthOfLongestCommonSubsequenceTopDown(char[] x, char[] y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        // inz
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // choice diagram
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) { //can consider
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else { // can'r consider
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
                }
            }
        }

        return t[m][n];
    }

    private static int lengthOfLongestCommonSubsequenceMemoize(char[] x, char[] y, int m, int n) {

        // base cond
        if (x.length == 0 || y.length == 0 || m == 0 || n == 0) {
            return 0;
        }

        if (t_memo[m][n] != -1) {
            return t_memo[m][n];
        }

        //choice diagram
        if (x[m - 1] == y[n - 1]) { // can consider
            return t_memo[m][n] = 1 + lengthOfLongestCommonSubsequenceRecursive(x, y, m - 1, n - 1);
        } else { //can't consider
            return t_memo[m][n] = Math.max(lengthOfLongestCommonSubsequenceRecursive(x, y, m, n - 1),
                    lengthOfLongestCommonSubsequenceRecursive(x, y, m - 1, n));
        }

    }

    private static int lengthOfLongestCommonSubsequenceRecursive(char[] x, char[] y, int m, int n) {
        // base cond
        if (x.length == 0 || y.length == 0 || m == 0 || n == 0) {
            return 0;
        }

        //choice diagram
        if (x[m - 1] == y[n - 1]) { // can consider
            return 1 + lengthOfLongestCommonSubsequenceRecursive(x, y, m - 1, n - 1);
        } else { //can't consider
            return Math.max(lengthOfLongestCommonSubsequenceRecursive(x, y, m, n - 1),
                    lengthOfLongestCommonSubsequenceRecursive(x, y, m - 1, n));
        }
    }
}
