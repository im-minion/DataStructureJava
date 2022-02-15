package misc;

/**
 * 
 * IMPORT THINGS
 * 
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array
 * is reverse sorted.
 * 
 * Best Case Time Complexity: O(n). Best case occurs when array is already
 * sorted.
 * 
 * Auxiliary Space: O(1)
 * 
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are
 * already sorted.
 * 
 * Sorting In Place: Yes
 * 
 * Stable: Yes
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] inputArray = { 5, 8, 4, 6, 9, 3, 1, 2, 7 };
        System.out.println("INPUT ::");
        printArray(inputArray);

        System.out.println("OUTPUT ::");
        printArray(bubbleSort(inputArray));

    }

    private static int[] bubbleSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    // swap jth and (j+1)th element
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
                System.out.println("After i = " + i + ", j = " + j);
                printArray(inputArray);
            }
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