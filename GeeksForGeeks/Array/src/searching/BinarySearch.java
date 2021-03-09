package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 17, 22, 35};

        System.out.println("Index: " + bSearch(arr, 0, arr.length - 1, 17));
    }

    private static int bSearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
