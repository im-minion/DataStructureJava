public class MergeSort {
    public static void main(String[] args) {
        int[] inputArray = { 5, 8, 4, 6, 9, 3, 1, 2, 7 };
        System.out.println("INPUT ::");
        printArray(inputArray);

        System.out.println("OUTPUT ::");
        mergeSort(inputArray, 0, inputArray.length - 1);
        printArray(inputArray);

    }

    private static void mergeSort(int[] inputArray, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;
            mergeSort(inputArray, lb, mid);
            mergeSort(inputArray, mid + 1, ub);
            mergeTwoSortedList(inputArray, lb, mid, ub);
        }
    }

    private static void mergeTwoSortedList(int[] inputArray, int lb, int mid, int ub) {
        int n1 = mid - lb + 1;
        int n2 = ub - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = inputArray[lb + i];

        for (int j = 0; j < n2; ++j)
            R[j] = inputArray[mid + 1 + j];

        int i = 0, j = 0;
        int k = lb;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                inputArray[k] = L[i];
                i++;
            } else {
                inputArray[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            inputArray[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            inputArray[k] = R[j];
            j++;
            k++;
        }

    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}