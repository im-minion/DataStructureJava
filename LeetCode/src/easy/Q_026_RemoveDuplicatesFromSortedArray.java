public class Q_026_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int c = 1;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                nums[c++] = nums[i + 1];
                i++;
            } else {
                i++;
            }
        }

        return c;
    }
}
