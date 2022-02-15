package gfg.rearrange;

import java.util.Arrays;

/*
    Rearrange an array in order – smallest, largest, 2nd smallest, 2nd largest, ..
    Difficulty Level : Easy
    Given an array of integers, task is to print the array in the order –
    smallest number, Largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on…..

    Examples:

    Input : arr[] = [5, 8, 1, 4, 2, 9, 3, 7, 6]
    Output :arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5}

    Input : arr[] = [1, 2, 3, 4]
    Output :arr[] = {1, 4, 2, 3}
*/
public class RearrangeSmallLargeSmallLarge {
    public static void main(String[] args) {
        int[] arr = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        int[] outArr = reArrange(arr);
        Arrays.stream(outArr).boxed().forEach(System.out::print);
    }

    private static int[] reArrange(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;
        int j = (n - 1);
        int putIndex = 0;
        int[] tempArr = new int[n];
        while (putIndex < n && i <= n / 2 && j >= n / 2) {
            tempArr[putIndex++] = arr[i];
            if (putIndex < n) tempArr[putIndex++] = arr[j];
            i++;
            j--;
        }
        return tempArr;
    }
}
