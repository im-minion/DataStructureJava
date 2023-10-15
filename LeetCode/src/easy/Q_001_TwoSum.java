package easy;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * Easy
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * */

public class Q_001_TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] op = new int[2];
        int n = nums.length;
        Map<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (valToIndex.containsKey(target - curr)) {
                op[0] = valToIndex.get(target - curr);
                op[1] = i;
                return op;
            } else {
                valToIndex.put(curr, i);
            }
        }
        return op;

    }
}
