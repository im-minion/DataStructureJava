package rearrange;

import java.util.Arrays;

/*
    Rearrange positive and negative numbers using inbuilt sort function
    Difficulty Level : Medium
    Given an array of positive and negative numbers, arrange them such that
    all negative integers appear before all the positive integers in the array without using any additional data structure like
    a hash table, arrays, etc. The order of appearance should be maintained.
    Examples:

    Input :  arr[] = [12, 11, -13, -5, 6, -7, 5, -3, -6]
    Output : arr[] = [-13, -5, -7, -3, -6, 12, 11, 6, 5]

    Input :  arr[] = [-12, 11, 0, -5, 6, -7, 5, -3, -6]
    Output : arr[] =  [-12, -5, -7, -3, -6, 0, 11, 6, 5]
*/
public class RearrangePosNeg {
    public static void main(String[] args) {
        int[] arr = {-12, 11, 0, -5, 6, -7, 5, -3, -6};
        reArrange(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;

        while (j < n) {
            if (arr[j] < 0) {
                //rotate
                //increment i
                rotateRight(arr, i, j);
                i++;
            } else if (arr[j] == 0) {
                // rotate
                rotateRight(arr, i, j);
            }
            j++;

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
