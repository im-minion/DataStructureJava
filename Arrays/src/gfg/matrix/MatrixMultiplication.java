package gfg.matrix;

/*
Matrix Multiplication | Recursive
Difficulty Level : Medium
Last Updated : 27 Dec, 2018
Given two matrices A and B. The task is to multiply matrix A and matrix B recursively. If matrix A and matrix B are not multiplicative compatible, then generate output “Not Possible”.

Examples :

Input: A = 12 56
45 78
B = 2 6
5 8
Output: 304 520
480 894

Input: A =
1 2 3
4 5 6
7 8 9

B =
1 2 3
4 5 6
7 8 9

Output: 30  36  42
66  81  96
102 126 150
*/
public class MatrixMultiplication {
    public static void main(String[] args) {
        int row1 = 3, col1 = 4, row2 = 4, col2 = 3;
        int[][] A = {
                {1, 2, 3, 1},
                {4, 5, 6, 1},
                {7, 8, 9, 1}
        };

        int[][] B = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {1, 1, 1}
        };

        int[][] arr = multiplyMatrix(row1, col1, A, row2, col2, B);
        MatrixUtil.printMatrix(arr);
    }

    private static int[][] multiplyMatrix(int row1, int col1, int[][] a, int row2, int col2, int[][] b) {
        int[][] op = new int[row1][col2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                int sum = 0;
                // op[i][j] = getMultiplicationOf(i, j, a, b);
                for (int k = 0; k < b.length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                op[i][j] = sum;

            }
        }
        return op;
    }

//    private static int getMultiplicationOf(int i, int j, int[][] a, int[][] b) {
//        int[] t1 = new int[a[0].length];
//        int[] t2 = new int[b.length];
//        //get ith row of a matrix
//        int c = 0;
//        for (int x = 0; x < a[0].length; x++) {
//            t1[c] = a[i][x];
//            c++;
//        }
//        //get jth col of b matrix
//        c = 0;
//        for (int x = 0; x < b.length; x++) {
//            t2[c] = b[x][j];
//            c++;
//        }
//        int sum = 0;
//        for (int x = 0; x < t1.length; x++) {
//            sum += t1[x] * t2[x];
//        }
//
//        return sum;
//    }
}
