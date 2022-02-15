package gfg.sorting;

import java.util.Arrays;

/*
Sort an array in wave form
Difficulty Level : Medium
Last Updated : 31 Aug, 2020
Given an unsorted array of integers, sort the array into a wave like array.
An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
Examples:

Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
{20, 5, 10, 2, 80, 6, 100, 3} OR
any other array that is in wave form

Input:  arr[] = {20, 10, 8, 6, 4, 2}
Output: arr[] = {20, 8, 10, 4, 6, 2} OR
{10, 8, 20, 2, 6, 4} OR
any other array that is in wave form

Input:  arr[] = {2, 4, 6, 8, 10, 20}
Output: arr[] = {4, 2, 8, 6, 20, 10} OR
any other array that is in wave form

Input:  arr[] = {3, 6, 5, 10, 7, 20}
Output: arr[] = {6, 3, 10, 5, 20, 7} OR
any other array that is in wave form
*/
public class SortInWaveForm {
    public static void main(String[] args) {
        int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
        sortInWave(arr);
//        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

        arr = new int[]{10, 5, 6, 3, 2, 20, 100, 80};
        sortInWaveInON(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    // O(n)
    private static void sortInWaveInON(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i += 2) {
            if (i > 0 && arr[i - 1] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            if (i < n - 1 && arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    // O(nLogn)
    private static void sortInWave(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
