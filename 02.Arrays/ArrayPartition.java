public class ArrayPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,9,5};
        boolean result = canPartition(nums);
        System.out.println(result);
    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 != 0) {
            return false;
        }

        return canPartitionDunction(nums, 0, 0, total);
    }

    public static boolean canPartitionDunction(int nums[], int index, int sum, int total) {
        if(sum * 2 == total) {
            return true;
        }
        if(sum > total / 2 || index >= nums.length){
            return false;
        }

        return canPartitionDunction(nums, index + 1, sum, total) || canPartitionDunction(nums, index + 1, sum + nums[index], total);
    }
}
