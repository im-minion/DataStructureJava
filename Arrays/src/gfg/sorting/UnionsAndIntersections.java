package gfg.sorting;

import java.util.ArrayList;
import java.util.List;

/*
Union and Intersection of two sorted arrays
Difficulty Level : Easy
Last Updated : 30 Oct, 2020
Given two sorted arrays, find their union and intersection.
Example:

Input : arr1[] = {1, 3, 4, 5, 7}
arr2[] = {2, 3, 5, 6}
Output : Union : {1, 2, 3, 4, 5, 6, 7}
Intersection : {3, 5}

Input : arr1[] = {2, 5, 6}
arr2[] = {4, 6, 8, 10}
Output : Union : {2, 4, 5, 6, 8, 10}
Intersection : {6}
*/
public class UnionsAndIntersections {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};
        int m = arr1.length;
        int n = arr2.length;
        List<Integer> unions = getUnion(arr1, arr2, m, n);
        unions.forEach(el -> System.out.print(el + " "));

        System.out.println();

        List<Integer> intersections = getIntersections(arr1, arr2, m, n);
        intersections.forEach(el -> System.out.print(el + " "));

    }

    private static List<Integer> getUnion(int[] arr1, int[] arr2, int m, int n) {
        List<Integer> op = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                op.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                op.add(arr2[j]);
                j++;
            } else {
                op.add(arr1[i]);
                i++;
            }
        }
        while (i < m) {
            op.add(arr1[i++]);
        }
        while (j < n) {
            op.add(arr2[j++]);
        }
        return op;
    }

    private static List<Integer> getIntersections(int[] arr1, int[] arr2, int m, int n) {
        List<Integer> op = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                op.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return op;
    }
}
