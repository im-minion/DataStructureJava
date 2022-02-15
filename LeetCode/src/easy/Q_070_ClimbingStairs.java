public class Q_070_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        // if(n == 0) return 1;
        // if(n == 1) return 1;
        // if(n == 2) return 2;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        // dp[2] = 2;
        // dp[3] = 3; // (1, 1, 1) (2 ,1) (1,2)
        // dp[4] = 5 = max(4, 5); //(1,1,1,1) (1,2,1) (1,1,2) (2,1,1) (2,2)
        // dp[5] = 6 = max(6, 6);
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; //Math.max(dp[i-1]+1, dp[i-2]+3);
        }

        return dp[n];
    }
}
