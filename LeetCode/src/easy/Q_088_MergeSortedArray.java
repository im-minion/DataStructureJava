public class Q_088_MergeSortedArray {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int finalIndex = m + n;

        if (m == 0) {
            while (n > 0 && finalIndex > 0) {
                nums1[finalIndex - 1] = nums2[n - 1];
                n--;
                finalIndex--;
            }
        }

        while (m > 0 && n > 0 && finalIndex > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[finalIndex - 1] = nums2[n - 1];
                n--;
            } else if (nums1[m - 1] > nums2[n - 1]) {
                nums1[finalIndex - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[finalIndex - 1] = nums1[m - 1];
                finalIndex--;
                nums1[finalIndex - 1] = nums2[n - 1];
                m--;
                n--;
            }
            finalIndex--;
        }

        while (n > 0 && finalIndex > 0) {
            nums1[finalIndex - 1] = nums2[n - 1];
            n--;
            finalIndex--;
        }
    }
}
