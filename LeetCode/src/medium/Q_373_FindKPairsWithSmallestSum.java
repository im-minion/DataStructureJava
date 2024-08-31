package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * Solved
 * Medium
 * Topics
 * Companies
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in non-decreasing order.
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 */
public class Q_373_FindKPairsWithSmallestSum {
    static class Pair {//} implements Comparable<Pair> {
        int a;
        int b;
        int sum;
        int idxa;
        int idxb;

        Pair(int a, int b, int idxa, int idxb) {
            this.a = a;
            this.b = b;
            this.sum = a + b;
            this.idxa = idxa;
            this.idxb = idxb;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.sum - p2.sum);
        for (int i = 0 ; i < Math.min(nums1.length, k) ; i++) {
            q.add(new Pair(nums1[i], nums2[0], i , 0));
        }

        List<List<Integer>> op = new ArrayList<>();

        while (k-- > 0 && !q.isEmpty()) {
            Pair p = q.poll();
            List<Integer> curr = new ArrayList<>();
            curr.add(p.a);
            curr.add(p.b);
            op.add(curr);
            if(p.idxb == nums2.length - 1) {
                continue;
            }
            q.offer(new Pair(nums1[p.idxa], nums2[p.idxb + 1], p.idxa, p.idxb + 1));
        }
        return op;
    }
}
