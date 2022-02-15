package gfg.rotations;

public class MinInSortedRotated {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 0, 1, 2, 3, 4};
        System.out.println(minElement(arr, arr.length));
    }

    private static int minElement(int[] arr, int n) {
        if (arr.length == 1) return arr[0];
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == arr[high])
                high--;
            else if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[high];
    }
}
