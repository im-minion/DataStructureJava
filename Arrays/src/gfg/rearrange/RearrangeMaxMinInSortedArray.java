package gfg.rearrange;

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
//        reArrange(arr);
//        reArrangeWithExtraSpace(arr);
        reArrangeWithoutExtraSpace(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    // time -> O(n) space O(1)
    private static void reArrangeWithoutExtraSpace(int[] arr) {
        int n = arr.length;
        int minIndex = 0;
        int maxIndex = n - 1;

        int maxElement = arr[maxIndex] + 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] = arr[i] + (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] /= maxElement;
    }

    // time->O(n) space -> O(n)
    private static void reArrangeWithExtraSpace(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int[] tempArr = new int[n];
        for (int x = 0; x < n && i <= j; x += 2) {
            tempArr[x] = arr[j];
            if (x + 1 < n) {
                tempArr[x + 1] = arr[i];
            }
            i++;
            j--;
        }
        Arrays.stream(tempArr).forEach(System.out::print);
        System.out.println();
        i = 0;
        for (int a : tempArr) {
            arr[i] = a;
            i++;
        }
    }

    //time =>  O(n* n/2) => O(n2), space -> (O1)
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
