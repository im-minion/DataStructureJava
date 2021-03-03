package rearrange;

import java.util.Arrays;

/*
Rearrange array such that even index elements are smaller and odd index elements are greater
Difficulty Level : Easy
Given an array, rearrange the array such that :

If index i is even, arr[i] <= arr[i+1]
If index i is odd, arr[i] >= arr[i+1]
Note : There can be multiple answers.

Examples:

Input  : arr[] = {2, 3, 4, 5}
Output : arr[] = {2, 4, 3, 5}
Explanation : Elements at even indexes are
smaller and elements at odd indexes are greater
than their next elements

Note : Another valid answer
is arr[] = {3, 4, 2, 5}
*/
public class EvenIndexSmallOddIndexBig {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        reArrange(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            } else if (i % 2 != 0 && arr[i] < arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

    }
}
