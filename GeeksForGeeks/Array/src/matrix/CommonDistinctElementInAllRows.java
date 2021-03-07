package matrix;

import java.util.*;

/*
Find distinct elements common to all rows of a matrix
Difficulty Level : Medium

Given a n x n matrix. The problem is to find all the distinct elements common to all rows of the matrix. The elements can be printed in any order.
Examples:

Input : mat[][] = {
                    {2, 1, 4, 3},
                    {1, 2, 3, 2},
                    {3, 6, 2, 3},
                    {5, 2, 5, 3}
                   }
Output : 2 3

Input : mat[][] = {
                    {12, 1, 14, 3, 16},
                    {14, 2, 1, 3, 35},
                    {14, 1, 14, 3, 11},
                    {14, 25, 3, 2, 1},
                    {1, 18, 3, 21, 14}
                  }

Output : 1 3 14
*/

public class CommonDistinctElementInAllRows {
    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, 4, 3},
                {1, 2, 3, 2},
                {3, 6, 2, 3},
                {5, 2, 5, 3}
        };

//        List<Integer> op = findAndPrintCommonElements(mat);
        List<Integer> op = findAndPrintCommonElementsLessSpace(mat);
        System.out.println("**************RESULT****************");
        System.out.println(op);
    }

    // total time => O(r*c), total space => O(r*c)
    private static List<Integer> findAndPrintCommonElements(int[][] arr) {
        List<Integer> op = new ArrayList<>();

        // space => O(r*c)
        HashSet[] h = new HashSet[arr.length - 1];

        // time=> O(r*c)
        for (int i = 0; i < arr.length - 1; i++) {
            h[i] = new HashSet<Integer>();
            for (int j = 0; j < arr[i].length; j++) {
                h[i].add(arr[i][j]);
            }
        }

        // time O(r*c)
        for (int i = 0; i < arr[0].length; i++) {
            boolean flag = false;
            for (int j = 0; j < h.length; j++) {
                if (!h[j].contains(arr[arr.length - 1][i])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                op.add(arr[arr.length - 1][i]);
            }
        }

        return op;
    }


    private static List<Integer> findAndPrintCommonElementsLessSpace(int[][] arr) {
        List<Integer> op = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr[0].length; i++) {
            map.put(arr[0][i], 1);
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (map.get(arr[i][j]) != null && map.get(arr[i][j]) == i) {
                    map.put(arr[i][j], i + 1);
                    if (i == (arr[0].length - 1)) {
                        op.add(arr[i][j]);
                    }
                }
            }
        }
        return op;
    }
}
