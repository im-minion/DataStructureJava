package gfg.searching;

/*

Maximum triplet sum in array
Difficulty Level : Easy

Given an array, the task is to find maximum triplet sum in the array.

Examples :

Input : arr[] = {1, 2, 3, 0, -1, 8, 10}
Output : 21
10 + 8 + 3 = 21

Input : arr[] = {9, 8, 20, 3, 4, -1, 0}
Output : 37
20 + 9 + 8 = 37
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxTripletSum {
    public static void main(String[] args) {
        int arr[] = {1, 0, 8, 6, 4, 2};
        int n = arr.length;
        List<Integer> op = maxSumTriplet(arr, n);
        System.out.println(op.stream().reduce(0, Integer::sum));
    }

    private static List<Integer> maxSumTriplet(int[] arr, int n) {
        Arrays.sort(arr);

        List<Integer> op = new ArrayList<>();
        op.add(arr[n - 1]);
        op.add(arr[n - 2]);
        op.add(arr[n - 3]);
        return op;
    }
}
