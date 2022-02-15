package gfg.matrix;

/*
Swap major and minor diagonals of a square matrix
Difficulty Level : Basic

Given a square matrix, swap the element of major and minor diagonals.

Major Diagonal Elements of a Matrix :
The Major Diagonal Elements are the ones that occur from Top Left of Matrix Down To Bottom Right Corner.
The Major Diagonal is also known as Main Diagonal or Primary Diagonal.

Minor Diagonal Elements of a Matrix :
The Minor Diagonal Elements are the ones that occur from Top Right of Matrix Down To Bottom Left Corner.
Also known as Secondary Diagonal.

Example :

Input :
0 1 2
3 4 5
6 7 8

Output :
2 1 0
3 4 5
8 7 6
*/
public class SwapDiagonal {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        swapDiagonal(mat);
        MatrixUtil.printMatrix(mat);
    }

    private static void swapDiagonal(int[][] arr) {
        int n = arr.length; // rowLEn == colLen
        for (int i = 0; i < n; i++) {
            //second loop not needed as we swap only when i == j, think!!!!
//            for (int j = 0; j < n; j++) {
//                if( i == j) {

            // swap arr[i][j] with arr[i][n-1-i]
            int temp = arr[i][i];
            arr[i][i] = arr[i][n - 1 - i];
            arr[i][n - 1 - i] = temp;
//                }
//            }
        }
    }
}
