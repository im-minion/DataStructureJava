package medium;

import java.util.Arrays;

public class Q_016_ThreeSumCloset {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(threeSumCloset(nums, 0));
    }

    public static int threeSumCloset(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                if (currSum > target) {
                    right--;
                } else {
                    left++;
                }

                if (Math.abs(currSum - target) < Math.abs(result - target)) {
                    result = currSum;
                }
            }
        }
        return result;

    }
}
