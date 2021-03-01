import java.util.Arrays;

/*
    Rearrange positive and negative numbers in O(n) time and O(1) extra space
    Difficulty Level : Medium
    https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/

    An array contains both positive and negative numbers in random order.
    Rearrange the array elements so that positive and negative numbers are placed alternatively.
    Number of positive and negative numbers need not be equal.
    If there are more positive numbers they appear at the end of the array.
    If there are more negative numbers, they too appear in the end of the array.

    For example,
    if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
    then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
*/
public class RearrangePositiveNegative {

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        reArrange(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int left = -1;
        int pivotElementValue = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] < pivotElementValue) {
                left++;
                // swap a[left], a[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int negStartIndex = 0;
        int posStartIndex = left + 1;
        while (negStartIndex < posStartIndex && posStartIndex < n && arr[negStartIndex] < 0) {
            int temp = arr[negStartIndex];
            arr[negStartIndex] = arr[posStartIndex];
            arr[posStartIndex] = temp;
            posStartIndex++;
            negStartIndex += 2;
        }
    }
}
