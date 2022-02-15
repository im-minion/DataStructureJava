package dp.lcs;

/*
Minimum number of deletions to make a string palindrome
Difficulty Level : Medium
Given a string of size ‘n’.
The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome.

Note: The order of characters should be maintained.

Examples :

Input : aebcbda
Output : 2
Remove characters 'e' and 'd'
Resultant string will be 'abcba'
which is a palindromic string

Input : geeksforgeeks
Output : 8
*/
public class Q19_MinDeletionToMakePalindrome {
    public static void main(String[] args) {
        String str = "aebcbda";
        System.out.println("Minimum number of deletions = " + minimumNumberOfDeletions(str));
    }

    private static int minimumNumberOfDeletions(String s) {
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
        return s.length() - t[m][n];
    }
}
