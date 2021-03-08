package matrix;

import java.util.ArrayList;
import java.util.Arrays;

/*
Move matrix elements in given direction and add elements with same value
Difficulty Level : Medium
Last Updated : 10 Aug, 2020
Given a matrix m[ ][ ] of size n x n consisting of integers and given a character ‘x’ indicating the direction. Value of ‘x’ can be ‘u’, ‘d’, ‘l’, ‘r’ indicating Up, Down, Left, Right correspondingly. The task is to move the element to given direction such that the consecutive elements having same value are added into single value and shift the rest element. Also, shift the element if the next element in given direction is 0.
For example :
Consider x = ‘l’ and matrix m[][],
32 3 3
0 0 1
10 10 8
After adding 3 in first row, 10 in third row and moving 1 in second row,
Matrix will become
32 6 0
1 0 0
20 8 0
Examples :


Input : x = 'l'
m[][] = { { 32, 3, 3, 3, 3 },
          { 0, 0, 1, 0, 0 },
          { 10, 10, 8, 1, 2},
          { 0, 0, 0, 0, 1},
          { 4, 5, 6, 7, 8 } }
Output :
32 6 6 0 0
1 0 0 0 0
20 8 1 2 0
1 0 0 0 0 0
4 5 6 7 8

Input : x = 'u'
m[][] = { { 10, 3, 32 },
        { 10, 0, 96 },
        { 5, 32, 96 } }
Output :
20 3 32
5 32 192
0 0 0

*/
public class MoveMatrixInGivenDirection {
    public static void main(String[] args) {
        char d = 'u';

        int[][] arr = {
                {2, 3, 3, 3, 3},
                {0, 0, 1, 0, 0},
                {4, 4, 8, 1, 2},
                {0, 1, 0, 1, 1},
                {4, 5, 6, 7, 8}
        };
        moveMatrix(d, arr);
        MatrixUtil.printMatrix(arr);
    }

    private static void moveMatrix(char d, int[][] arr) {
        int n = arr.length;
        switch (d) {
            case 'l':
                // for each row
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> v = new ArrayList<>();
                    ArrayList<Integer> w = new ArrayList<>();
                    int j;
                    for (j = 0; j < n; j++) {
                        if (arr[i][j] != 0) {
                            v.add(arr[i][j]);
                        }
                    }
                    for (j = 0; j < v.size(); j++) {
                        if (j < v.size() - 1 && v.get(j).equals(v.get(j + 1))) {
                            w.add(2 * v.get(j));
                            j++;
                        } else {
                            w.add(v.get(j));
                        }
                    }
                    // filling the each row element to 0
                    Arrays.fill(arr[i], 0);
                    j = 0;
                    for (int it = 0; it < w.size(); it++)
                        arr[i][j++] = w.get(it);
                }
                break;
            case 'r':
                // for each row
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> v = new ArrayList<>();
                    ArrayList<Integer> w = new ArrayList<>();
                    int j;
                    for (j = 0; j < n; j++) {
                        if (arr[i][j] != 0) {
                            v.add(arr[i][j]);
                        }
                    }
                    for (j = 0; j < v.size(); j++) {
                        if (j < v.size() - 1 && v.get(j).equals(v.get(j + 1))) {
                            w.add(2 * v.get(j));
                            j++;
                        } else {
                            w.add(v.get(j));
                        }
                    }
                    // filling the each row element to 0
                    Arrays.fill(arr[i], 0);
                    j = n - 1;
                    for (int it = w.size() - 1; it >= 0; it--)
                        arr[i][j--] = w.get(it);
                }
                break;

            case 'd':
                // for each row
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> v = new ArrayList<>();
                    ArrayList<Integer> w = new ArrayList<>();
                    int j;
                    for (j = n - 1; j >= 0; j--) {
                        if (arr[j][i] != 0) {
                            v.add(arr[j][i]);
                        }
                    }
                    for (j = 0; j < v.size(); j++) {
                        if (j < v.size() - 1 && v.get(j).equals(v.get(j + 1))) {
                            w.add(2 * v.get(j));
                            j++;
                        } else {
                            w.add(v.get(j));
                        }
                    }
                    // filling the each row element to 0
                    for (j = 0; j < n; j++)
                        arr[j][i] = 0;
                    j = n - 1;
                    for (int it = 0; it < w.size(); it++)
                        arr[j--][i] = w.get(it);
                }
                break;
            case 'u':// ^
                // for each row
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> v = new ArrayList<>();
                    ArrayList<Integer> w = new ArrayList<>();
                    int j;
                    for (j = n - 1; j >= 0; j--) {
                        if (arr[j][i] != 0) {
                            v.add(arr[j][i]);
                        }
                    }
                    for (j = 0; j < v.size(); j++) {
                        if (j < v.size() - 1 && v.get(j).equals(v.get(j + 1))) {
                            w.add(2 * v.get(j));
                            j++;
                        } else {
                            w.add(v.get(j));
                        }
                    }
                    // filling the each row element to 0
                    for (j = 0; j < n; j++)
                        arr[j][i] = 0;
                    j = 0;
                    for (int it = w.size() - 1; it >= 0; it--)
                        arr[j++][i] = w.get(it);
                }
                break;
        }
    }
}
