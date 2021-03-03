package rearrange;

import java.util.Arrays;

/*
Rearrange an array in maximum minimum form | Set 1
Difficulty Level : Medium

Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.

Examples:

Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
Output: arr[] = {7, 1, 6, 2, 5, 3, 4}

Input: arr[] = {1, 2, 3, 4, 5, 6}
Output: arr[] = {6, 1, 5, 2, 4, 3}

Expected time complexity: O(n).
*/
public class RearrangeMaxMinInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reArrange(arr);
//        rightRotate(arr, 0, 6);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while (i <= n) {
            rightRotate(arr, i, j);
            i += 2;
        }
    }

    private static void rightRotate(int[] arr, int i, int j) {
        // 1234 => 4123
        int t = arr[j];
        int x;
        for (x = j; x > i; x--) {
            arr[x] = arr[x - 1];
        }
        arr[i] = t;
    }
}
