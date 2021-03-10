package searching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*Find the two repeating elements in a given array
Difficulty Level : Medium
Last Updated : 03 Feb, 2021
You are given an array of n+2 elements.
All elements of the array are in range 1 to n.
And all elements occur once except two numbers which occur twice.
Find the two repeating numbers.

Example:

Input:
arr = [4, 2, 4, 5, 2, 3, 1]
n = 5
Output:
4 2
Explanation:
The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice.
So the output should be 4 2.
*/
public class TwoRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        List<Integer> op = getRepeating(arr, arr_size);
        System.out.println(op);
    }

    private static List<Integer> getRepeating(int[] arr, int n) {
        List<Integer> op = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!h.add(arr[i])) {
                op.add(arr[i]);
            }
        }
        return op;
    }
}
