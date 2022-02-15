package gfg.searching;

/*
Find a Fixed Point (Value equal to index) in a given array
Difficulty Level : Easy
Last Updated : 04 Sep, 2019
Given an array of n distinct integers sorted in ascending order,
write a function that returns a Fixed Point in the array,
if there is any Fixed Point present in array, else returns -1.
Fixed Point in an array is an index i such that arr[i] is equal to i.
Note that integers in array can be negative.

Examples:

Input: arr[] = {-10, -5, 0, 3, 7}
Output: 3  // arr[3] == 3

Input: arr[] = {0, 2, 5, 8, 17}
Output: 0  // arr[0] == 0


Input: arr[] = {-10, -5, 3, 4, 7, 9}
Output: -1  // No Fixed Point
*/
public class FixedPointValue {
    public static void main(String[] args) {
        int[] arr = {-10, -5, 3, 4, 7, 9};
        int n = arr.length;
        int op = linearSearch(arr, n);
        System.out.println("LinearSearch : " + op);
        op = bSearch(arr, 0, n - 1);
        System.out.println("BinarySearch : " + op);
    }

    private static int bSearch(int[] arr, int l, int h) {
        if (l <= h) {
            int mid = (l + h) / 2;
            if (mid == arr[mid])
                return mid;
            else if (mid > arr[mid]) {
                return bSearch(arr, (mid + 1), h);
            } else {
                return bSearch(arr, l, (mid - 1));
            }
        }
        return -1;
    }

    private static int linearSearch(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
