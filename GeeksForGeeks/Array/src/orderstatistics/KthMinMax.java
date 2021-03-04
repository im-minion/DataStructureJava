package orderstatistics;

import java.util.Arrays;

/*
K’th Smallest/Largest Element in Unsorted Array | Set 1
Difficulty Level : Medium

Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array.
It is given that all array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 4
Output: 10
*/
public class KthMinMax {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int min = getKthMin(arr, 3); // get 3rd min
        System.out.printf("min: %d%n", min);
        int max = getKthMax(arr, 1); //get first max
        System.out.printf("min: %d%n", max);
    }

    private static int getKthMax(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    private static int getKthMin(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
