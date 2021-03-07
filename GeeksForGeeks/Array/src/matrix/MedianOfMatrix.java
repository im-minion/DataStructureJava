package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Find median in row wise sorted matrix
Difficulty Level : Hard

We are given a row-wise sorted matrix of size r*c, we need to find the median of the matrix given.
It is assumed that r*c is always odd.
Examples:

Input : 1 3 5
2 6 9
3 6 9
Output : Median is 5
If we put all the values in a sorted
array A[] = 1 2 3 3 5 6 6 9 9)

Input: 1 3 4
2 5 6
7 8 9
Output: Median is 5
*/

public class MedianOfMatrix {
    public static void main(String[] args) {
        int r = 3, c = 3;
        int m[][] = {{1, 3, 4}, {2, 5, 6}, {7, 8, 9}};

        System.out.println("Median is " + binaryMedian(m, r, c));
    }

    private static int binaryMedian(int[][] arr, int r, int c) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                list.add(arr[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(list.size() / 2); //size is always odd so median is center element
    }
}
