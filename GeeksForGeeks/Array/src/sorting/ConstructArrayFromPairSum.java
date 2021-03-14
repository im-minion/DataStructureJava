package sorting;
/*
Construct an array from its pair-sum array
Difficulty Level : Medium

Given a pair-sum array and size of the original array (n), construct the original array.

A pair-sum array for an array is the array that contains sum of all pairs in ordered form.
For example pair-sum array for arr[] = {6, 8, 3, 4} is {14, 9, 10, 11, 12, 7}.
In general, pair-sum array for arr[0..n-1]
is {arr[0]+arr[1], arr[0]+arr[2], ……., arr[1]+arr[2], arr[1]+arr[3], ……., arr[2]+arr[3], arr[2]+arr[4], …., arr[n-2]+arr[n-1}.

“Given a pair-sum array, construct the original array.”

We strongly recommend to minimize your browser and try this yourself.
*/

public class ConstructArrayFromPairSum {
    public static void main(String[] args) {
        int[] pair = {15, 13, 11, 10, 12, 10, 9, 8, 7, 5};
        int n = 5;
        int[] arr = new int[n];
        constructArr(arr, pair, n);
        for (int a : arr)
            System.out.print(a + " ");
    }

    private static void constructArr(int[] arr, int[] pair, int n) {
        arr[0] = (pair[0] + pair[1] - pair[n - 1]) / 2;
        for (int i = 1; i < n; i++) {
            arr[i] = pair[i - 1] - arr[0];
        }
    }
}
