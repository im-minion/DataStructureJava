package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Q_347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] op = new int[k];
        Map<Integer, Integer> valToTimes = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for(int n: nums) {
            if(!valToTimes.containsKey(n)) {
                valToTimes.put(n, 1);
            } else {
                valToTimes.put(n, valToTimes.get(n) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: valToTimes.entrySet()) {
            q.add(entry);
            if(q.size() > k) {
                q.poll();
            }
        }
        int idx = 0;
        while(!q.isEmpty()) {
            op[idx++] = q.poll().getKey();
        }
        return op;
    }
}
