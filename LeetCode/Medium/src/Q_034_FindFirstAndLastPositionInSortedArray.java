/*34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 */

public class Q_034_FindFirstAndLastPositionInSortedArray {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] op = new int[2];
        op[0] = -1;
        op[1] = -1;

        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                //go left
                int t = mid;
                while (t >= 0 && nums[t] == target) {
                    t--;
                }
                op[0] = t + 1;

                // go right
                int p = mid;
                while (p < nums.length && nums[p] == target) {
                    p++;
                }
                op[1] = p - 1;
                break;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return op;
    }
}
