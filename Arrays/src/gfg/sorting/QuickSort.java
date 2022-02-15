package gfg.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 13, 5, 8, 3, 2, 11};
        sortWithQuickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    private static void sortWithQuickSort(int[] arr, int start, int end) {
        if (start > end) return;
        int pivot = partition(arr, start, end);
        sortWithQuickSort(arr, start, pivot - 1);
        sortWithQuickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start;
        int j = i + 1;
        // select first element as pivot
        int pivot = arr[i];
        while (j <= end) {
            if (pivot >= arr[j]) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        // swap ith with p
        int t = arr[start];
        arr[start] = arr[i];
        arr[i] = t;
        return i;
    }
}
