package gfg.rearrange;

import java.util.Arrays;

/*
Segregate even and odd numbers | Set 3
Difficulty Level : Easy

Given an array of integers, segregate even and odd numbers in the array.
All the even numbers should be present first, and then the odd numbers.

Examples:

Input: arr[] = 1 9 5 3 2 6 7 11
Output: 2 6 5 3 1 9 7 11

Input: arr[] = 1 3 2 4 7 6 9 10
Output:  2 4 6 10 7 1 9 3
*/
public class SegregateEvenOdd {
    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 3, 2, 6, 7, 11};
        reOrder(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void reOrder(int[] arr) {
        int n = arr.length;
        int lastOdd = -1;
        int j = 0;
        while (j < n) {
            if (arr[j] % 2 == 0) {
                lastOdd++;
                // swap arr[lastOdd] with arr[j]
                int temp = arr[lastOdd];
                arr[lastOdd] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
    }
}
