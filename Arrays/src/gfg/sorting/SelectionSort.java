package gfg.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {5, 7, 4, 6, 1, 3, 9, 2, 8};
        sortWithSelection(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    /*
     * Select Min Element and put it in place
     * */
    private static void sortWithSelection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            // swap i and indexOfMin
            int temp = arr[i];
            arr[i] = arr[indexOfMin];
            arr[indexOfMin] = temp;
        }
    }
}
