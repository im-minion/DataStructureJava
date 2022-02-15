/*
* Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
* */

public class Q_027_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                // do nothing
            } else {
                nums[c++] = nums[i];
            }
        }

        return c;
    }
}
