import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Minimum swaps required to bring all elements less than or equal to k together
    Difficulty Level : Medium
    https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
    Given an array of n positive integers and a number k.
    Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

    Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
    Output: 1

    Explanation:
    To bring elements 2, 1, 3 together, swap
    element '5' with '3' such that final array
    will be-
    arr[] = {2, 1, 3, 6, 5}

    Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
    Output: 2
* */
public class MinSwapRequired {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 5, 8, 7, 4};
        int res = minSwapRequired(arr, 5);
        System.out.println(res);
    }
    // O(n) + O(nlongn) + O(n) => O(nlogn)
    private static int minSwapRequired(int[] arr, int k) {
        int currGroupCount = 0;
        List<Integer> resArray = new ArrayList<>();
        // O(n)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                currGroupCount++;
            } else {
                resArray.add(currGroupCount);
                currGroupCount = 0;
            }
        }
        resArray.add(currGroupCount);
        int res = 0;
        // O(nlongn)
        Collections.sort(resArray);
        // O(n)
        for (int i = 0; i < resArray.size() - 1; i++) {
            res += resArray.get(i);
        }
        return res;
    }
}
