public class QuickSort {
    public static void main(String[] args) {
        int[] inputArray = { 5, 8, 4, 6, 9, 3, 1, 2, 7 };
        System.out.println("INPUT ::");
        printArray(inputArray);

        System.out.println("OUTPUT ::");
        quickSort(inputArray, 0, inputArray.length - 1);
        printArray(inputArray);

    }

    /**
     * @param inputArray => provided input, the whole array
     * @param start      => from where to start the
     * @param end        => till where we need to go
     * 
     *                   So, the first iteration will be => 0 to n-1 Second will be
     *                   from => 0 to partition-1 and again from => partition to n-1
     *                   and so on.........
     */
    private static void quickSort(int[] inputArray, int start, int end) {
        /**
         * Quick sort is recursive and divide-conquer technique, so define 3 basic
         * things as we do for any recursive function.
         * 
         * 1.Termination condition 2.Operation 3. Recursive Call
         */

        // Termination condition
        if (start >= end) {
            return;
        }

        // Operation, 1.Find Pivot 2. Find next partition index
        int pivot = inputArray[(start + end) / 2];
        int partitionIndex = partition(inputArray, start, end, pivot);

        // Recursive Call
        quickSort(inputArray, start, partitionIndex - 1);
        quickSort(inputArray, partitionIndex, end);
    }

    /**
     * 
     * @param inputArray => provided input, the whole array
     * @param start      => from where to start the
     * @param end        => till where we need to go
     * @param pivot      => pivot, to which we compare and perform operation on
     *                   start and end
     * @return partitionIndex => the partition index which ensures left side is
     *         smaller and right side is greater
     */
    private static int partition(int[] inputArray, int start, int end, int pivot) {
        // Partition technique
        // move from start to end:
        // when we get start > pivot and end < pivot swap

        // keep doing that til start <= end

        while (start <= end) {
            while (inputArray[start] < pivot) {
                start++;
            }
            while (inputArray[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = inputArray[start];
                inputArray[start] = inputArray[end];
                inputArray[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}