package lcs;

/*
Minimum insertions to form a palindrome | DP-28
Difficulty Level : Hard

Given a string str, the task is to find the minimum number of characters to be inserted to convert it to palindrome.
Before we go further, let us understand with few examples:


ab: Number of insertions required is 1 i.e. bab
aa: Number of insertions required is 0 i.e. aa
abcd: Number of insertions required is 3 i.e. dcbabcd
abcda: Number of insertions required is 2 i.e. adcbcda which is same as number of insertions in the substring bcd(Why?).
abcde: Number of insertions required is 4 i.e. edcbabcde
*/
public class Q23_MinNoOfInsertionToMakeAStringPalindrome {
    public static void main(String[] args) {
        String str = "aebcbda";
        String rev = new StringBuilder(str).reverse().toString();
        // Function Call
        String op = printMinDelAndInsert(str.toCharArray(), rev.toCharArray(), str.length(), rev.length());
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
        return "Insertion Required : " + (m - t[m][n]);
    }
}
