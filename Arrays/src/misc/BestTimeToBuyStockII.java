package misc;

public class BestTimeToBuyStockII {
    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int result = getMaxProfit(arr);
        System.out.println(result);
    }

    private static int getMaxProfit(int[] arr) {
        // Max Sub-array using Kadane's Algorithm
        int total = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                total += arr[i + 1] - arr[i];
            }
        }
        return total;
    }
}
