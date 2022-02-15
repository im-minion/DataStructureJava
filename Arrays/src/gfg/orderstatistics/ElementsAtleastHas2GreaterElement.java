package gfg.orderstatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find all elements in array which have at-least two greater elements
Difficulty Level : Easy
Given an array of n distinct elements,
the task is to find all elements in array which have at-least two greater elements than themselves.

Examples :

Input : arr[] = {2, 8, 7, 1, 5};
Output : 2  1  5
Explanation:
The output three elements have two or more greater elements

Explanation:
Input  : arr[] = {7, -2, 3, 4, 9, -1};
Output : -2  3  4 -1
*/
public class ElementsAtleastHas2GreaterElement {
    public static void main(String[] args) {
        int[] arr = {7, -2, 3, 4, 9, -1};
        int n = arr.length;
        List<Integer> result = getAllElements(arr, n);
        System.out.println("Approach 1: " + result);
        result = getAllElementsApproach2(arr, n);
        System.out.println("Approach 2: " + result);
        result = getAllElementsApproach3(arr, n);
        System.out.println("Approach 3: " + result);
    }

    // O(n2)
    private static List<Integer> getAllElements(int[] arr, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
                if (count >= 2) {
                    result.add(arr[i]);
                    break;
                }
            }
        }
        return result;
    }

    // O(nlogn)
    private static List<Integer> getAllElementsApproach2(int[] arr, int n) {
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // O(n)
    private static List<Integer> getAllElementsApproach3(int[] arr, int n) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }

        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < second) {
                result.add(arr[i]);
            }
        }
        return result;
    }
}
