package matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Input : matrix[3][3] =
{1 2 3
4 5 6
7 8 9}
Output :
Lower :             Upper :
1 0 0               1 2 3
4 5 0               0 5 6
7 8 9               0 0 9

Input : matrix[3][3] =
{7 8 9
3 2 1
6 5 4}
Output :
Lower :             Upper :
7 0 0               7 8 9
3 2 0               0 2 1
6 5 4               0 0 4
*/
public class PrintUpperMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println("Lower triangular matrix: ");
        int[][] op = lower(matrix);
        MatrixUtil.printMatrix(op);

        System.out.println("Upper triangular matrix: ");
        int[][] op2 = upper(matrix);
        MatrixUtil.printMatrix(op2);


        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Lower triangular without Extra Space : ");
        lowerWithoutSpace(matrix2);
        MatrixUtil.printMatrix(matrix2);


        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Upper triangular without Extra Space : ");
        upperWithoutSpace(matrix3);
        MatrixUtil.printMatrix(matrix3);
    }

    private static void upperWithoutSpace(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i < j) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void lowerWithoutSpace(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i > j) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static int[][] lower(int[][] arr) {
        int[][] op = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], i, op[i], i, arr.length - i);
        }
        return op;
    }

    private static int[][] upper(int[][] arr) {
        int[][] op = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, op[i], 0, i + 1);
        }
        return op;
    }
}
