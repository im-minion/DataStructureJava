package searching;

/*
Maximum equlibrium sum in an array
Difficulty Level : Easy
Last Updated : 04 Dec, 2020
Given an array arr[]. Find maximum value of prefix sum which is also suffix sum for index i in arr[].
Examples :

Input : arr[] = {-1, 2, 3, 0, 3, 2, -1}
Output : 4
Prefix sum of arr[0..3] =
Suffix sum of arr[3..6]

Input : arr[] = {-2, 5, 3, 1, 2, 6, -4, 2}
Output : 7
Prefix sum of arr[0..3] =
Suffix sum of arr[3..7]

*/
public class EquilibriumSum {
    public static void main(String[] args) {
        int[] arr = {-2, 5, 3, 1, 2, 6, -4, 2};
        int n = arr.length;
        System.out.println(findMaxSum(arr, n));
    }

    private static int findMaxSum(int[] arr, int n) {
        int i = 0, j = n - 1;
        int[] firstSum = new int[n];
        int[] secondSum = new int[n];
        firstSum[i] = arr[i];
        secondSum[j] = arr[j];
        i++;
        j--;
        while (i < n && j >= 0) {
            firstSum[i] = firstSum[i - 1] + arr[i];
            i++;
            secondSum[j] = secondSum[j + 1] + arr[j];
            j--;
        }
        for (int x = 0; x < n; x++) {
            if (firstSum[x] == secondSum[x]) {
                return firstSum[x];
            }
        }
        return -1;
    }
}
