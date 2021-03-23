package knapsackunbounded;/*
Printing Shortest Common Supersequence
Difficulty Level : Hard

Given two strings X and Y, print the shortest string that has both X and Y as subsequences.
If multiple shortest supersequence exists, print any one of them.

Examples:

Input: X = "AGGTAB",  Y = "GXTXAYB"
Output: "AGXGTXAYB" OR "AGGXTXAYB"

OR Any string that represents shortest
supersequence of X and Y

Input: X = "HELLO",  Y = "GEEK"
Output: "GEHEKLLO" OR "GHEEKLLO" OR Any string that represents shortest supersequence of X and Y
*/

public class Q20_PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(printShortestSuperSeq(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    private static String printShortestSuperSeq(char[] x, char[] y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        //inz to 0

        //choice diagram
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    // consider
                    t[i][j] = t[i - 1][j - 1];
                } else {
                    //not consider
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // lets traverse the matrix and get the SCS
        int i = m;
        int j = n;
        StringBuilder op = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x[i - 1] == y[j - 1]) {
                op.append(x[i - 1]);
                j--;
                i--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    op.append(x[i - 1]);
                    i--;
                } else {
                    op.append(y[j - 1]);
                    j--;
                }
            }
        }

        while (i > 0) {
            op.append(x[i - 1]);
            i--;
        }

        while (j > 0) {
            op.append(y[j - 1]);
            j--;
        }

        return op.reverse().toString();
    }
}
