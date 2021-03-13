package sorting;

import java.util.Arrays;

public class SortingWithAbsoluteDiff {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 9, 2};
        sortWithBubble(arr, 7);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    private static void sortWithBubble(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (Math.abs(arr[j] - k) > Math.abs(arr[j + 1] - k)) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
