package lcs;

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
    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";

        // Function Call
        String op = printMinDelAndInsert(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println(op);
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
