package knapsackunbounded;/*
Printing Longest Common Subsequence
Difficulty Level : Medium

Given two sequences, print the longest subsequence present in both of them.
Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/

public class Q15_PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "ABCDGH";
        String Y = "AEDFHR";
        int m = X.length();
        int n = Y.length();
        String op = lcs(X.toCharArray(), Y.toCharArray(), m, n);
        System.out.println("LargestCommonSubsequence : " + op);
    }

    private static String lcs(char[] x, char[] y, int m, int n) {
        StringBuilder op = new StringBuilder();
        int[][] t = new int[m + 1][n + 1];
        // inz qst row and qst col to zero
        // already zeros no need to do anything

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) { //consider
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else { //can't consider
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (x[i - 1] == y[j - 1]) {
                op.append(x[i - 1]);
                i--;
                j--;
            } else {
                // max i, j-1 and i-1, j
                if (t[i][j - 1] > t[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return op.reverse().toString();
    }
}
