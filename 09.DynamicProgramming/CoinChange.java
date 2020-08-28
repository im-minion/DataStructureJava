import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(arr, amount));
    }

    private static int coinChange(int[] arr, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + arr[i - j]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}