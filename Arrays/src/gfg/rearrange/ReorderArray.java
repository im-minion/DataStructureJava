package gfg.rearrange;
/*
    Reorder an array according to given indexes
    Difficulty Level : Medium
    Given two integer arrays of same size, “arr[]” and “index[]”, reorder elements in “arr[]” according to given index array. It is not allowed to given array arr’s length.

    Example:

    Input:  arr[]   = [10, 11, 12];
    index[] = [1, 0, 2];
    Output: arr[] = [11, 10, 12]
    index[] = [0,  1,  2]

    Input:  arr[] = [50, 40, 70, 60, 90]
    index[] = [3,  0,  4,  1,  2]
    Output: arr[] = [40, 60, 90, 50, 70]
    index[] = [0,  1,  2,  3,   4]
    Expected time complexity O(n) and auxiliary space O(1)
*/

import java.util.Arrays;

public class ReorderArray {
    public static void main(String[] args) {
        int[] arr = {50, 40, 70, 60, 90};
        int[] indexes = {3, 0, 4, 1, 2};
        reOrder(arr, indexes);
        // Arrays.stream(arr).forEach(System.out::print);
    }

    // O(n) space and O(n) time
    private static void reOrder(int[] arr, int[] indexes) {
        int n = arr.length;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < n; i++) {
            newArr[indexes[i]] = arr[i];
        }
        Arrays.stream(newArr).forEach(a -> System.out.print(a + " "));
    }
}
