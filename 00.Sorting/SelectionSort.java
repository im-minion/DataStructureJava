/**
 * Selection Sort
 * 
 * Time Complexity: O(n2) as there are two nested loops.
 * 
 * Auxiliary Space: O(1) The good thing about selection sort is it never makes
 * more than O(n) swaps and can be useful when memory write is a costly
 * operation.
 * 
 * Exercise : Sort an array of strings using Selection Sort
 * 
 * Stability : The default implementation is not stable. However it can be made
 * stable. Please see stable selection sort for details.
 * 
 * In Place : Yes, it does not require extra space.
 * 
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] inputArray = { 5, 8, 4, 6, 9, 3, 1, 2, 7 };
        System.out.println("INPUT ::");
        printArray(inputArray);

        System.out.println("OUTPUT ::");
        printArray(selectionSort(inputArray));

    }

    private static int[] selectionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            // find min(index of min) from i to length
            int indexOfMin = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            // swap inputArray[indexOfMin] => inputArray[i]
            int temp = inputArray[indexOfMin];
            inputArray[indexOfMin] = inputArray[i];
            inputArray[i] = temp;
            System.out.println("After i = " + i);
            printArray(inputArray);
        }
        return inputArray;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}