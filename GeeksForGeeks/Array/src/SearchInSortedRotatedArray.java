public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] Arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int op = searchInArray(Arr, 3);
        System.out.println(op);
    }

    private static int searchInArray(int[] arr, int k) {
        return bSearch(arr, 0, arr.length - 1, k);
    }

    private static int bSearch(int[] arr, int low, int high, int k) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] >= arr[low]) {
                if (k >= arr[low] && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (k >= arr[mid] && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
