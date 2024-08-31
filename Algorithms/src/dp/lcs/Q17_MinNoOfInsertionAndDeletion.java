package dp.lcs;

import java.util.Arrays;

/*
Minimum number of deletions and insertions to transform one string into another
Difficulty Level : Medium

Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2.
It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input :
str1 = "heap", str2 = "pea"
Output :
Minimum Deletion = 2 and
Minimum Insertion = 1
Explanation:
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.
*/
public class Q17_MinNoOfInsertionAndDeletion {
    static int t[][];

    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";

        // Function Call
        System.out.println("ByTopDown -");
        String op = printMinDelAndInsert(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println(op);

        System.out.println("ByRec -");
        t = new int[str1.length() + 1][str2.length() + 1];
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        String op2 = printMinDelAndInsertWithRecursive(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println(op2);
    }

    private static String printMinDelAndInsertWithRecursive(char[] X, char[] Y, int m, int n) {
        int op = solveByRec(X, Y, m, n);
        return "Deletion : " + (m - op) + "\nInsertion : " + (n - op);
    }

    private static int solveByRec(char[] X, char[] Y, int m, int n) {
        if (X.length == 0 || Y.length == 0 || m == 0 || n == 0) {
            return 0;
        }

        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (X[m - 1] == Y[n - 1]) {
            t[m][n] = 1 + solveByRec(X, Y, m - 1, n - 1);
        } else {
            t[m][n] = Math.max(solveByRec(X, Y, m - 1, n), solveByRec(X, Y, m, n - 1));
        }

        return t[m][n];
    }

    private static String printMinDelAndInsert(char[] x, char[] y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        //inz 0's

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return "Deletion : " + (m - t[m][n]) + "\nInsertion : " + (n - t[m][n]);
    }
}
