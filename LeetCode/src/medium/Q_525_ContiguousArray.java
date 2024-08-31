package medium;

import java.util.HashMap;
/*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
public class Q_525_ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length ;
        if(n == 0) return 0;
        if(n == 1) return 0;

        HashMap<Integer, Integer> diffToIndex = new HashMap<>();
        int zeros = 0, ones = 0, maxLen = 0;

        diffToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++; else ones++;
            int diff = zeros - ones;
            if (diffToIndex.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - diffToIndex.get(diff));
            } else {
                diffToIndex.put(diff, i);
            }
        }
        return maxLen;
    }
}
