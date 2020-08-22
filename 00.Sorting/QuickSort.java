/**
 * 
 * Worst-case analysis:
 * 
 * The most unbalanced partition occurs when one of the sub-lists returned by
 * the partitioning routine is of size n − 1. This may occur if the pivot
 * happens to be the smallest or largest element in the list, or in some
 * implementations when all the elements are equal. If this happens repeatedly
 * in every partition, then each recursive call processes a list of size one
 * less than the previous list. Consequently, we can make n − 1 nested calls
 * before we reach a list of size 1. This means that the call tree is a linear
 * chain of n − 1 nested calls. The ith call does O(n − i) work to do the
 * partition, and, so in that case Quicksort takes O(n²) time.
 * 
 * Best-case analysis:
 * 
 * In the most balanced case, each time we perform a partition we divide the
 * list into two nearly equal pieces. This means each recursive call processes a
 * list of half the size. Consequently, we can make only log2 n nested calls
 * before we reach a list of size 1. This means that the depth of the call tree
 * is log2 n. But no two calls at the same level of the call tree process the
 * same part of the original list; thus, each level of calls needs only O(n)
 * time all together (each call has some constant overhead, but since there are
 * only O(n) calls at each level, this is subsumed in the O(n) factor). The
 * result is that the algorithm uses only O(n log n) time.
 * 
 * Average-case analysis:
 * 
 * To sort an array of n distinct elements, quicksort takes O(n log n) time in
 * expectation, averaged over all n! permutations of n elements with equal
 * probability. We list here three common proofs to this claim providing
 * different insights into quick-sort's workings.
 */

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
                // swap inputArray[start] <=> inputArray[end];
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