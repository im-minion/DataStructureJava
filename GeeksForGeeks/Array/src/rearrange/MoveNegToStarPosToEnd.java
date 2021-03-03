package rearrange;

import java.util.Arrays;

/*
 Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy

An array contains both positive and negative numbers in random order.
Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples :

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
* */
public class MoveNegToStarPosToEnd {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        reArrange(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (arr[i] > 0 && arr[j] < 0) { // i => +, j => -
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (arr[i] < 0 && arr[j] > 0) { // i => -, j => +
                i++;
                j--;
            } else if (arr[i] > 0 && arr[j] > 0) { // i => +, j => +
                j--;
            } else { // i => -, j => -
                i++;
            }
        }
    }
}
// -12 -3 -13 -5 -7 6 5 11 11
// -12 11 -13 -5 6 -7 5 -3-6