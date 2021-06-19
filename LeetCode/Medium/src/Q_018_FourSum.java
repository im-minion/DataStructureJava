import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_018_FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> op = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int currSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (currSum < target) {
                        left++;
                    } else if (currSum > target) {
                        right--;
                    } else {
                        op.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return op;
    }
}
