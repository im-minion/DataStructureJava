/*
Shortest Common Supersequence
Difficulty Level : Medium

Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.

Examples :

Input:   str1 = "geek",  str2 = "eke"
Output: 5
Explanation:
String "geeke" has both string "geek" and "eke" as subsequences.

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  9
Explanation:
String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.
*/

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String X = "ABCDGH";
        String Y = "AEDFHR";

        System.out.println("Length of the shortest super sequence is " + shortestSuperSequence(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    private static int shortestSuperSequence(char[] x, char[] y, int m, int n) {

        int[][] t = new int[m + 1][n + 1];
        // inz 1st row and 1st col to 0
        // already 0

        // choice diagram
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return m + n - t[m][n];
    }
}
