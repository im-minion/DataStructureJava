package rangequeries;

import java.util.ArrayList;
import java.util.List;

/*
Queries for counts of array elements with values in given range
Difficulty Level : Medium

Given an unsorted array of size n, find no of elements between two elements i and j (both inclusive).

Examples:

Input :  arr = [1 3 3 9 10 4]
i1 = 1, j1 = 4
i2 = 9, j2 = 12
Output : 4
2
The numbers are: 1 3 3 4 for first query
The numbers are: 9 10 for second query
*/
public class QueriesCountsOfArrayElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 9, 10, 3};
        int n = arr.length;

        // Answer queries
        int i = 1, j = 4;
        System.out.println(findInRange(arr, n, i, j));

        i = 9;
        j = 12;
        System.out.println(findInRange(arr, n, i, j));
    }

    private static List<Integer> findInRange(int[] arr, int n, int lowest, int highest) {
        List<Integer> op = new ArrayList<>();
        for (Integer a : arr) {
            if (a >= lowest && a <= highest) {
                op.add(a);
            }
        }
        return op;
    }
}
