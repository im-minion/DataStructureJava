package matrix;


/*
Rotate a matrix by 90 degree without using any extra space | Set 2
Difficulty Level : Medium
Given a square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.

Examples:

Input:
1  2  3
4  5  6
7  8  9
Output:
3  6  9
2  5  8
1  4  7
Rotated the input matrix by
90 degrees in anti-clockwise direction.

Input:
1  2  3  4
5  6  7  8
9 10 11 12
13 14 15 16
Output:
4  8 12 16
3  7 11 15
2  6 10 14
1  5  9 13
Rotated the input matrix by
90 degrees in anti-clockwise direction.
*/

public class Rotate90ClockAndAntiClock {
    public static void main(String[] args) {

        // AntiClockwise
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate90(arr);
        flipEachColumn(arr);
        MatrixUtil.printMatrix(arr);

        System.out.println("\n\n");

        // ClockWise
        int[][] arr2 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate90(arr2);
        flipEachRow(arr2);
        MatrixUtil.printMatrix(arr2);
    }


    private static void rotate90(int[][] arr) {
        // transpose only traverse upper half of the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                // arr[i][j] arr[j][i]
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    // column-reverse
    private static void flipEachColumn(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr[i].length / 2); j++) {
                int n = arr[i].length;
                // arr[i][j] <==> arr[n-1-i][j]
                int temp = arr[j][i];
                arr[j][i] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = temp;
            }
        }
    }

    // row-reverse
    private static void flipEachRow(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                // arr[i][j] arr[i][n-1-j]
                int n = arr[i].length;
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = temp;
            }
        }
    }

}
