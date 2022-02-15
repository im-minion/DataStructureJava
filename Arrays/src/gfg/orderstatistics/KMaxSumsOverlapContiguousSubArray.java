package gfg.orderstatistics;

import java.util.ArrayList;
import java.util.List;

/*
TODO: Understand this shit
15. K maximum sums of overlapping contiguous sub-arrays
Difficulty Level : Hard

Given an array of Integers and an Integer value k, find out k sub-arrays(may be overlapping), which have k maximum sums.

Examples:

Input : arr = {4, -8, 9, -4, 1, -8, -1, 6}, k = 4
Output : 9 6 6 5
*/
public class KMaxSumsOverlapContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, -1, -3, -5, 6, 2, -6, -2};
        int k = 3;
        List<Integer> op = getResult(arr, k);
        System.out.println(op);
    }

    private static List<Integer> getResult(int[] arr, int k) {
        List<Integer> op = new ArrayList<>();
//        Tried the sliding window but failed
//        int n = arr.length;
//        int i = 0;
//        int j = 0;
//        int currSum = 0;
//        while (j < n) {
//            currSum += arr[j];
//            if (currSum <= sum) {
//                j++;
//            } else { // currSum >= sum
//                while (currSum >= sum) {
//                    op.add(currSum);
//                    currSum = currSum - arr[i];
//                    i++;
//                }
//                j++;
//            }
//        }
        return op;
    }
}
