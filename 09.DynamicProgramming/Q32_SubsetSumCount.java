import java.util.Arrays;

public class Q32_SubsetSumCount {
    private static int[][] t_memo;

    private static int[][] t;

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;

        t_memo = new int[n + 1][sum + 1];
        for (int[] row : t_memo) {
            Arrays.fill(row, -1);
        }
        System.out.println("solveByRecursive : " + solveByRecursive(arr, sum, n));

        t = new int[n + 1][sum + 1];
        System.out.println("solveByTopDown : " + solveByTopDown(arr, sum, n));
    }

    private static int solveByTopDown(int[] arr, int sum, int n) {
        //inz
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        //choice diagram
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    //we have choice whether to include or not
                    t[i][j] =
                            // include
                            t[i - 1][j - arr[i - 1]] +
                                    //not include
                                    t[i - 1][j];
                } else {
                    //can't include
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    private static int solveByRecursive(int[] arr, int sum, int n) {
        // base cond
        if (n == 0 && sum == 0) {
            return 1;
        }
        if (n == 0 && sum > 0) {
            return 0;
        }
        if (n > 0 && sum == 0) {
            return 1;
        }

        // memoize
        if (t_memo[n][sum] != -1) {
            return t_memo[n][sum];
        }

        //choice diag
        if (arr[n - 1] <= sum) {
            //include or not
            return t_memo[n][sum] = solveByRecursive(arr, sum - arr[n - 1], n - 1) + solveByRecursive(arr, sum, n - 1);
        } else {
            // can't include
            return t_memo[n][sum] = solveByRecursive(arr, sum, n - 1);
        }
    }
}
