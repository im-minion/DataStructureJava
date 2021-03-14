package sorting;

/*
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Difficulty Level : Medium

Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that
sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60],
your program should be able to find that the subarray lies between the indexes 3 and 8.

2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50],
your program should be able to find that the subarray lies between the indexes 2 and 5.
*/
public class MinLengthUnsortedSubArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        int arr_size = arr.length;
        int[] op = getUnsortedSubArrayIndexes(arr, arr_size);
        System.out.println("start : " + op[0]);
        System.out.println("end : " + op[1]);
    }

    private static int[] getUnsortedSubArrayIndexes(int[] arr, int n) {
        int[] op = new int[2];
        int start = 0;
        int end = n - 1;
        int i;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        if (i == n - 1) {
            System.out.println("Already Sorted");
            return op;
        }
        start = i;

        int j;
        for (j = n - 1; j > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                break;
            }
        }
        end = j;

        int min = arr[start];
        int max = arr[end];

        for (int x = start; x <= end; x++) {
            if (arr[x] < min) {
                min = arr[x];
            }
            if (arr[x] > max) {
                max = arr[x];
            }
        }

        for (int x = 0; x < start; x++) {
            if (arr[x] > min) {
                start = x;
                break;
            }
        }

        for (int x = n - 1; x > end; x--) {
            if (arr[x] < max) {
                end = x;
                break;
            }
        }

        op[0] = start;
        op[1] = end;
        return op;
    }
}
