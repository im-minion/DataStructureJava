package gfg.searching;

/*
Searching in an array where adjacent differ by at most k
Difficulty Level : Easy

A step array is an array of integer where each element has a difference of at most k with its neighbor.
Given a key x, we need to find the index value of x if multiple element exist return the first occurrence of the key.

Examples:

Input : arr[] = {4, 5, 6, 7, 6}
k = 1
x = 6
Output : 2
The first index of 6 is 2.

Input : arr[] = {20, 40, 50, 70, 70, 60}
k = 20
x = 60
Output : 5
The index of 60 is 5
*/

public class SearchArrayAdjDiffK {
    public static void main(String[] args) {
        int arr[] = {2, 4, 5, 7, 7, 6};
        int key = 6;
        int maxDiff = 2;
        int n = arr.length;

        System.out.println("Element " + key +
                " is present at index "
                + search(arr, n, maxDiff, key));
    }

    private static int search(int[] arr, int n, int maxDiff, int key) {
        int i = 0;
        while (i < n) {
            if (arr[i] == key)
                return i;
            i = i + Math.max(1, Math.abs(arr[i] - key) / maxDiff);
            i++;
        }
        return -1;
    }
}
