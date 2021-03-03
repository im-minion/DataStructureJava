package rearrange;

import java.util.Arrays;

/*
 *Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’ | Set 1
 * Difficulty Level : Hard
 * Given an array of size n where all elements are distinct and in range from 0 to n-1,
 * change contents of arr[] so that arr[i] = j is changed to arr[j] = i.
 *
 * Example 1:
Input: arr[]  = {1, 3, 0, 2};
Output: arr[] = {2, 0, 3, 1};
Explanation for the above output.
Since arr[0] is 1, arr[1] is changed to 0
Since arr[1] is 3, arr[3] is changed to 1
Since arr[2] is 0, arr[0] is changed to 2
Since arr[3] is 2, arr[2] is changed to 3

Example 2:
Input: arr[]  = {2, 0, 1, 4, 5, 3};
Output: arr[] = {1, 2, 0, 5, 3, 4};

Example 3:
Input: arr[]  = {0, 1, 2, 3};
Output: arr[] = {0, 1, 2, 3};

Example 4:
Input: arr[]  = {3, 2, 1, 0};
Output: arr[] = {3, 2, 1, 0};
 * */
public class RearrangeArrItoJ {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 4, 5, 3};
        reArrange(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
//            int t = arr[i];
            temp[arr[i]] = i;
        }
        int i = 0;
        for (int a : temp) {
            arr[i] = a;
            i++;
        }
    }
}
