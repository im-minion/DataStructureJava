package gfg.sorting;

/*
Two elements whose sum is closest to zero
Difficulty Level : Easy

Question:
An Array of integers is given, both +ve and -ve.
You need to find the two elements such that their sum is closest to zero.
For the below array, program should print -80 and 85.
*/

import java.util.Arrays;

public class TwoElementClosestToZero {
    public static void main(String[] args) {
        int[] arr = {1, 60, -10, 70, -80, 85};
        int[] result = minAbsSumPair(arr, arr.length);
        System.out.println("first : " + result[0]);
        System.out.println("second : " + result[1]);
    }

    // O(nLogn)
    private static int[] minAbsSumPair(int[] arr, int n) {
        int[] op = new int[2];
        // O(nLogn)
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        int min = Integer.MAX_VALUE;
        while (i < j) {
            int currSum = arr[i] + arr[j];
            min = Math.min(currSum, min);
            if (min == currSum) {
                op[0] = arr[i];
                op[1] = arr[j];
            }
            i++;
            j--;
        }
        return op;
    }
}
