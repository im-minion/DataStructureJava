package gfg.rearrange;

import java.util.Arrays;

/*
    Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
    Difficulty Level : Medium
    https://www.geeksforgeeks.org/rearrange-array-arri-arrj-even-arri/

    Given an array of n elements.
    Our task is to write a program to rearrange the array such that
    elements at even positions are greater than all elements before it and elements at odd positions are less than all elements before it.

    Examples:

    Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
    Output : 4 5 3 6 2 7 1

    Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8}
    Output : 4 5 2 6 1 8 1 8
*/

public class RearrangeOddEvenPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; // op => 4 5 3 6 2 7 1

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8}; // op => 4 5 3 6 2 7 1 8

        // 3 4 2 5 1 6 0 => 7 elements Index in op
        // 4 5 3 6 2 7 1

        // 3 4 2 5 1 6 0 7 => 8 elements Index in op
        // 4 5 3 6 2 7 1 8

        int[] out = reArrange(arr);
        Arrays.stream(out).boxed().forEach(System.out::print);
    }

    private static int[] reArrange(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int[] outArr = new int[n];
        int i, j;
        if (n % 2 == 0) { // even eg. n = 8
            i = (n / 2) - 1; // 3
            j = (n / 2); // 4
        } else { //odd eg. n = 7
            i = (n / 2); // 3
            j = (n / 2) + 1; // 4
        }
        for (int x = 0; x < n; x = x + 2) {
            outArr[x] = arr[i];
            if (j < n)
                outArr[x + 1] = arr[j];
            i--;
            j++;
        }
        return outArr;
    }
}
