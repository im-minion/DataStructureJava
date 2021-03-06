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

        // AntiClockwise - constant space
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate90(arr);
        flipEachColumn(arr);
        System.out.println("Anticlockwise ::::");
        MatrixUtil.printMatrix(arr);

        // AntiClockwise - extra space
        int[][] arr3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] outArr = rotateClockWiseWithExtraSpace(arr3);
        System.out.println("Anticlockwise with extra space ::::");
        MatrixUtil.printMatrix(outArr);

        System.out.println("\n");

        // ClockWise - constant space
        int[][] arr2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate90(arr2);
        flipEachRow(arr2);
        System.out.println("Clockwise ::::");
        MatrixUtil.printMatrix(arr2);


        // ClockWise - extra space
        int[][] arr4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Clockwise wit extra space ::::");
        int[][] outArr2 = rotateAntiClockWiseWithExtraSpace(arr4);
        MatrixUtil.printMatrix(outArr2);
    }

    private static int[][] rotateAntiClockWiseWithExtraSpace(int[][] arr) {
        int[][] brr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, k = arr.length - 1; j < arr.length; j++, k--) {
                brr[i][j] = arr[k][i];
            }
        }
        return brr;
    }

    private static int[][] rotateClockWiseWithExtraSpace(int[][] arr) {
        int[][] brr = new int[arr.length][arr[0].length];

        for (int i = 0, k = arr.length - 1; i < arr.length; i++, k--) {
            for (int j = 0; j < arr.length; j++) {
                brr[i][j] = arr[j][k];
            }
        }

        return brr;
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
