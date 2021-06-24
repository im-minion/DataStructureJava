public class Q_033_SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target) return mid;

            else if (nums[mid] >= nums[l]) {
                if (nums[l] <= target && target < nums[mid]) { // l <= target < mid
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[h] >= target && target > nums[mid]) { // h >= target > mid
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}
