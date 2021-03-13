package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 6, 1, 3, 9, 2, 8};
        sortWithBubble(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    /*
     * Throw Largest element at last.
     * Start both loops from 0th index index and perform second iter less than i
     * */
    private static void sortWithBubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
