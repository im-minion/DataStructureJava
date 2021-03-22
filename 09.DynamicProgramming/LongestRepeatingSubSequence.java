public class LongestRepeatingSubSequence {
    public static void main(String[] args) {
        String str = "AABEBCDD";
        System.out.println(longestRepeatedSubSeq(str.toCharArray(), str.toCharArray(), str.length(), str.length()));
    }

    private static String longestRepeatedSubSeq(char[] x, char[] y, int m, int n) {
        StringBuilder op = new StringBuilder();
        int[][] t = new int[m + 1][n + 1];

        // choice diagram
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((x[i - 1] == y[j - 1]) && i != j) { //can consider
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else { // can't consider
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (t[i - 1][j - 1] + 1 == t[i][j]) { // match
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
