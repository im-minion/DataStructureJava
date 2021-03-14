package sorting;

/*
Sort an array containing two types of elements
Difficulty Level : Easy

Given an array of 0s and 1s in random order.
Segregate 0s on left side and 1s on right side of the array.
Traverse array only once.
Examples:

Input :  arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output : arr[] = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

Input :  arr[] = [1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1]
Output : arr[] = [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]
*/

public class Sort0sand1sArray {
    public static void main(String[] args) {
        int[] arr
                = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0};

        segregate0and1(arr, arr.length);
        for (int a : arr)
            System.out.print(a + " ");
    }

    private static void segregate0and1(int[] arr, int length) {
        int i = 0;
        int j = length - 1;
        while (i < j && i < length && j >= 0) {
            if (arr[i] == 1 && arr[j] == 0) {
                arr[i] = 0;
                arr[j] = 1;
            }
            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }

        }
    }
}
