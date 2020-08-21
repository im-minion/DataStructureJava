/**
 * 
 * Time Complexity: O(n*2)
 * 
 * Auxiliary Space: O(1)
 * 
 * Boundary Cases: Insertion sort takes maximum time to sort if elements are
 * sorted in reverse order. And it takes minimum time (Order of n) when elements
 * are already sorted.
 * 
 * Algorithmic Paradigm: Incremental Approach
 * 
 * Sorting In Place: Yes
 * 
 * Stable: Yes
 * 
 * Online: Yes
 * 
 * Uses: Insertion sort is used when number of elements is small. It can also be
 * useful when input array is almost sorted, only few elements are misplaced in
 * complete big array.
 * 
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] inputArray = { 5, 8, 4, 6, 9, 3, 1, 2, 7 };
        System.out.println("INPUT ::");
        printArray(inputArray);

        System.out.println("OUTPUT ::");
        printArray(insertionSort(inputArray));

    }

    private static int[] insertionSort(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int j = i;
            while (j > 0 && inputArray[j] < inputArray[j - 1]) {
                // swap jth and (j-1)th element
                int temp = inputArray[j];
                inputArray[j] = inputArray[j - 1];
                inputArray[j - 1] = temp;
                j--;
            }
            System.out.println("After i = " + i + ", j = " + j);
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