public class Q_035_SearchInsertPosition {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
