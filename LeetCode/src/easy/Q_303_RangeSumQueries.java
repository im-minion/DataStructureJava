package easy;


/*Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3*/
public class Q_303_RangeSumQueries {
    int range[];
    public Q_303_RangeSumQueries(int[] nums) { // this is NumArray() in actual code.
        if(nums == null) return;
        range = new int[nums.length];
        if(nums.length == 0) return;
        for (int i = 0 ; i < nums.length ; i++) {
            if (i == 0) {
                range[0] = nums[i];
            } else {
                range[i] = range[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return range[right];
        return range[right] - range[left -1];
    }
}
