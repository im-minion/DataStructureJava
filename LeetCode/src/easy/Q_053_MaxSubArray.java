public class Q_053_MaxSubArray {
    public static void main(String[] args) {

    }

    private static int maxSubArray(int[] nums) {
        int op = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum < nums[i]) {
                currSum = nums[i];
            }
            op = Math.max(op, currSum);
        }


        return op;
    }
}
