package misc;

public class TotalDecodeMessages_DecodeWays {

    public static void main(String[] args) {
        System.out.println(countWays("2112"));
        System.out.println(countWays("2101"));
    }

    public static int countWays(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1] % 1000000007;
            else
                dp[i] = 0;

            if (i > 1) {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                    dp[i] = ((dp[i] % 1000000007) + (dp[i - 2] % 1000000007)) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}
