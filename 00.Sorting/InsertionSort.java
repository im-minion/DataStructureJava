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
            for (int j = i; j > 0; j--) {
                while (inputArray[j] < inputArray[j - 1]) {
                    // swap jth and (j-1)th element
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j - 1];
                    inputArray[j - 1] = temp;
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