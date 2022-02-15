package dp.lcs;

public class Q22_SubSequencePatternMatching {
    public static void main(String[] args) {
        String x = "AXY";
        String y = "ADXCPY";

        boolean op = subSequencePatternMatching(x.toCharArray(), y.toCharArray(), x.length(), y.length());
        System.out.println(op);
    }

    private static boolean subSequencePatternMatching(char[] x, char[] y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[m][n] == x.length;
    }
}
