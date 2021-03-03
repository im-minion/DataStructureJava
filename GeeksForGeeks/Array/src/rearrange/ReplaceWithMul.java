package rearrange;

import java.util.Arrays;

/*
    Replace every array element by multiplication of previous and next
    Difficulty Level : Easy
    Last Updated : 11 Dec, 2018
    Given an array of integers, update every element with multiplication of previous and next elements with following exceptions.
    a) First element is replaced by multiplication of first and second.
    b) Last element is replaced by multiplication of last and second last.

    Example:

    Input: arr[] = {2, 3, 4, 5, 6}
    Output: arr[] = {6, 8, 15, 24, 30}

    // We get the above output using following
    // arr[] = {2*3, 2*4, 3*5, 4*6, 5*6}
*/

public class ReplaceWithMul {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        reOrder(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void reOrder(int[] arr) {
        int n = arr.length;
        int prevElem = arr[0];
        int lastElem = arr[n - 1];
        arr[0] = arr[0] * arr[1];
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            arr[i] = prevElem * arr[i + 1];
            prevElem = curr;
        }
        arr[n - 1] = prevElem * arr[n - 1];
    }
}
