package gfg.searching;

import java.util.Arrays;

/*
Find the only repetitive element between 1 to n-1
Difficulty Level : Easy
We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order.
The array has only one repetitive element. We need to find the repetitive element.

Examples :

Input  : a[] = {1, 3, 2, 3, 4}
Output : 3

Input  : a[] = {1, 5, 1, 2, 3, 4}
Output : 1
*/
public class OnlyRepetitiveElement {
    public static void main(String[] args) {
        int[] arr = {9, 8, 2, 6, 1, 8, 5, 3, 4, 7};
        System.out.println(findRepeating(arr));
    }

    private static int findRepeating(int[] arr) {
        int n = arr.length;
        // arr contains 1 to n-1 element so the expected sum is
        int sumOfNMinusOneElements = n * (n - 1) / 2;
        // actual sum of array is
        int sumOfArrayElements = Arrays.stream(arr).sum();
        return sumOfArrayElements - sumOfNMinusOneElements;
    }
}
