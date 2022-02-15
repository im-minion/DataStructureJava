package gfg.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Squares of Matrix Diagonal Elements
Difficulty Level : Basic

You have given an integer matrix with odd dimensions. Find the square of the diagonals elements on both sides.

Examples:

Input  :
1 2 3
4 5 6
7 8 9
Output :  Diagonal one: 1 25 81
Diagonal two: 9 25 49

Input  :
2 5 7
3 7 2
5 6 9
Output :  Diagonal one : 4 49 81
Diagonal two : 49 49 25
*/
public class SquareOfDiagonals {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<List<Integer>> squares = getDiagSqaures(mat);

        System.out.println("Primary :::");
        System.out.println(squares.get(0));
        System.out.println("Secondary :::");
        System.out.println(squares.get(1));

    }

    private static List<List<Integer>> getDiagSqaures(int[][] arr) {
        List<List<Integer>> op = new ArrayList<>();
        op.add(new ArrayList<>());
        op.add(new ArrayList<>());
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            op.get(0).add(arr[i][i] * arr[i][i]);
            op.get(1).add(arr[i][n - 1 - i] * arr[i][n - 1 - i]);
        }


        return op;

    }
}
