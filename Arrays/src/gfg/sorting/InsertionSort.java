package gfg.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 6, 1, 3, 9, 2, 8};
        sortWithInsert(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    /*
     * Insert min element in the sorted previous array
     * */
    private static void sortWithInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
    }
}
