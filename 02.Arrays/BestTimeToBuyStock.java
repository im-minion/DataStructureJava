public class BestTimeToBuyStock {
    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int result = getMaxProfit(arr);
        System.out.println(result);
    }

    private static int getMaxProfit(int[] arr) {
        // Max Sub-array using Kadane's Algorithm
        int maxSoFar = 0;
        int maxCurr = 0;
        for (int i = 1; i < arr.length; i++) {
            maxCurr = Math.max(0, maxCurr += arr[i] - arr[i - 1]);
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }
        return maxSoFar;
    }
}
