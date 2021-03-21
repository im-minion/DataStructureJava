/*
Longest Common Substring | DP-29
Difficulty Level : Medium

Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

Examples :

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
Explanation:
The longest common substring is “abcdez” and is of length 6.
*/
public class LongestCommonSubstring {
    static int r = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();
//        LCSubStrRecursive(X.toCharArray(), Y.toCharArray(), m, n, count, r);
//        System.out.println("LCSRecursive  :" + count);
//        System.out.println("LCSMemoize  :" + LCSubStrMemoize(X.toCharArray(), Y.toCharArray(), m, n));
        System.out.println("LCSTopDown  :" + LCSubStrTopDown(X.toCharArray(), Y.toCharArray(), m, n));
    }

    private static int LCSubStrTopDown(char[] x, char[] y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        int op = 0;
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
                    op = Math.max(op, t[i][j]);
                } else { // can't consider
                    t[i][j] = 0;
                }
            }
        }

        return op;
    }

//    private static void LCSubStrRecursive(char[] x, char[] y, int m, int n, int count, int r) {
//        if (x.length == 0 || y.length == 0 || m == 0 || n == 0) {
//            r = Math.max(r, count);
//            return ;
//        }
//        if (x[m - 1] == y[n - 1]) {
//            // consider
//            1 + LCSubStrRecursive(x, y, m - 1, n - 1);
//        } else {
//             r = Math.max(LCSubStrRecursive(x, y, m - 1, n),
//                    LCSubStrRecursive(x, y, m, n - 1));
//        }
//    }
}
