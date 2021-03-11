package searching;

/*
Find a triplet that sum to a given value
Difficulty Level : Medium

Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
If there is such a triplet present in array, then print the triplet and return true. Else return false.
Example:

Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
Output: 12, 3, 9
Explanation: There is a triplet (12, 3 and 9) present
in the array whose sum is 24.

Input: array = {1, 2, 3, 4, 5}, sum = 9
Output: 5, 3, 1
Explanation: There is a triplet (5, 3 and 1) present
in the array whose sum is 9.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TripletWithGivenSum {
    public static void main(String[] args) {
        int[] A = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int n = A.length;
//        int[] op = find3Numbers(A, n, sum);
//        Arrays.stream(op).forEach(el -> System.out.print(el + " "));
        List<Integer[]> op2 = findAllTriplates(A, n, sum);
        op2.forEach(o -> {
            Arrays.stream(o).forEach(el -> System.out.print(el + " "));
            System.out.println();
        });
    }

    private static int[] find3Numbers(int[] arr, int n, int sum) {
        int[] op = new int[3];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int currSum = sum - arr[i];
            for (int j = i + 1; j < n; j++) {
                if (hashSet.contains(currSum - arr[j])) {
                    op[0] = arr[i];
                    op[1] = arr[j];
                    op[2] = currSum - arr[j];
                    break;
                }
                hashSet.add(arr[j]);
            }
        }
        return op;
    }

    private static List<Integer[]> findAllTriplates(int[] arr, int n, int sum) {
        List<Integer[]> op2 = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int currSum = sum - arr[i];
            for (int j = i + 1; j < n; j++) {
                if (hashSet.contains(currSum - arr[j])) {
                    Integer[] t = {arr[i], arr[j], currSum - arr[j]};
                    op2.add(t);
                    break;
                }
                hashSet.add(arr[j]);
            }
        }
        return op2;
    }
}
