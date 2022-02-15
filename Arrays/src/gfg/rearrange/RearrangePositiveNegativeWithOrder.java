package gfg.rearrange;

import java.util.Arrays;

/*
    Rearrange array in alternating positive & negative items with O(1) extra space | Set 1
    Difficulty Level : Hard

    Given an array of positive and negative numbers, arrange them in an alternate fashion such that
    every positive number is followed by negative and vice-versa maintaining the order of appearance.
    Number of positive and negative numbers need not be equal.
    If there are more positive numbers they appear at the end of the array.
    If there are more negative numbers, they too appear in the end of the array.

    Examples :

    Input:  arr[] = {1, 2, 3, -4, -1, 4}
    Output: arr[] = {-4, 1, -1, 2, 3, 4}

    Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
    output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
*/
public class RearrangePositiveNegativeWithOrder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        reArrange(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;

        while (j < n && i < n && i <= j) {
            if (arr[i] > 0 && arr[j] < 0) { // i => +, j => -
                rotateRight(arr, i, j);
                i += 2;
            } else if (arr[i] < 0 && arr[j] > 0) { // i => -, j => +
                i++;
                rotateRight(arr, i, j);
                i++;
                j++;
            } else if (arr[i] > 0 && arr[j] > 0) { // i => +, j => +
                j++;
            } else {
                j++;
            }
        }
    }

    private static void rotateRight(int[] arr, int start, int end) {
        // 1 2 3 4 => 4 1 2 3
        int temp = arr[end];
        int i;
        for (i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[i] = temp;
    }
}
