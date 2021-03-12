package rangequeries;

/*
6. Range Queries for Frequencies of array elements
Difficulty Level : Medium

Given an array of n non-negative integers.
The task is to find frequency of a particular element in the arbitrary range of array[].
The range is given as positions (not 0 based indexes) in array. There can be multiple queries of given type.
Examples:

Input  : arr[] = {2, 8, 6, 9, 8, 6, 8, 2, 11};
left = 2, right = 8, element = 8
left = 2, right = 5, element = 6
Output : 3
1
The element 8 appears 3 times in arr[left-1..right-1]
The element 6 appears 1 time in arr[left-1..right-1]
*/
public class RangeQueriesForFrequencyOfArrayElement {
    public static void main(String[] args) {
        int[] arr = {2, 8, 6, 9, 8, 6, 8, 2, 11};
        int n = arr.length;

        // Print frequency of 2 from position 1 to 6
        System.out.println("Frequency of 2 from 1 to 6 = " + findFrequency(arr, n, 1, 6, 2));

        // Print frequency of 8 from position 4 to 9
        System.out.println("Frequency of 8 from 4 to 9 = " + findFrequency(arr, n, 4, 9, 8));
    }

    // Returns count of element in arr[left-1..right-1]
    public static int findFrequency(int[] arr, int n, int left, int right, int element) {
        int count = 0;
        for (int i = left - 1; i < right; ++i)
            if (arr[i] == element)
                ++count;
        return count;
    }
}
