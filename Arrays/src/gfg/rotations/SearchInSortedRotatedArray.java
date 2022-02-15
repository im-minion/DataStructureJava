package gfg.rotations;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] Arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int op = searchInArray(Arr, 3);
        System.out.println(op);
    }

    private static int searchInArray(int[] arr, int toBeSearched) {
        return bSearch(arr, 0, arr.length - 1, toBeSearched);
    }

    private static int bSearch(int[] arr, int low, int high, int toBeSearched) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == toBeSearched) {
                return mid;
            } else if (arr[mid] >= arr[low]) {
                if (toBeSearched >= arr[low] && toBeSearched <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (toBeSearched >= arr[mid] && toBeSearched <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
