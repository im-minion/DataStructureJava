public class Q_169_MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int major = nums[0];
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (c == 0) {
                c = 1;
                major = nums[i];
            } else if (nums[i] == major) {
                c++;
            } else {
                c--;
            }
        }
        return major;
    }
}
