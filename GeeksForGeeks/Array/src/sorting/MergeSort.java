package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 4, 6, 9, 3, 1, 2, 7};
        System.out.println("INPUT ::");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

        System.out.println("OUTPUT ::");
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    private static void mergeSort(int[] arr, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            mergeSort(arr, lowerBound, mid);
            mergeSort(arr, mid + 1, upperBound);
            mergeSortedLists(arr, lowerBound, mid, upperBound);
        }
    }

    private static void mergeSortedLists(int[] arr, int lowerBound, int mid, int upperBound) {
        int leftArrLen = mid - lowerBound + 1;
        int rightArrLen = upperBound - mid;
        int leftArr[] = new int[leftArrLen];
        int rightArr[] = new int[rightArrLen];
//        int i = lowerBound;
//        int j = mid + 1;

        for (int x = 0; x < leftArrLen; x++) {
            leftArr[x] = arr[lowerBound + x];
        }

        for (int x = 0; x < rightArrLen; x++) {
            rightArr[x] = arr[mid + 1 + x];
        }
        // fill arr from lowerBound to upperBound based on the the comparison
        int i = 0, j = 0;
        int k = lowerBound;
        while (i < leftArrLen && j < rightArrLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                k++;
                i++;
            } else {
                arr[k] = rightArr[j];
                k++;
                j++;
            }
        }
        while (i < leftArrLen) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }
        while (j < rightArrLen) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }

}
