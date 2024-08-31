package medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 56. Merge Intervals
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Q_056_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for(int i = 1 ; i < intervals.length ; i++) {
            int[] lastAdded = result.get(result.size()-1);
            if(lastAdded[1] >= intervals[i][0]) {
                lastAdded[1] = Math.max(lastAdded[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
