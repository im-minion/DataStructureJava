package gfg.matrix;

/*
Shift matrix elements row-wise by k
Difficulty Level : Easy

Given a square matrix mat[][] and a number k. The task is to shift first k elements of each row in the right of the matrix.

Examples :

Input : mat[N][N] = {
{1, 2, 3},
{4, 5, 6},
{7, 8, 9}
}
k = 2
Output :mat[N][N] = {
{3, 1, 2}
{6, 4, 5}
{9, 7, 8}
}

Input : mat[N][N] = {
{1, 2, 3, 4}
{5, 6, 7, 8}
{9, 10, 11, 12}
{13, 14, 15, 16}
}
k = 2
Output :mat[N][N] = {
{3, 4, 1, 2}
{7, 8, 5, 6}
{11, 12, 9, 10}
{15, 16, 13, 14}
}

*/

public class ShiftRowsByK {
    public static void main(String[] args) {
        System.out.println("Right Rotate :::: ");
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int k = 2;

        // Function call
        rightShiftMatrixByK(mat, k);
        MatrixUtil.printMatrix(mat);

        System.out.println("Left Rotate :::: ");
        int[][] mat2 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int k2 = 1;

        // Function call
        leftShiftMatrixByK(mat2, k2);
        MatrixUtil.printMatrix(mat2);
    }

    private static void rightShiftMatrixByK(int[][] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            // rotate arr[i] by k
            rightRotate(arr[i], k);
        }
    }

    private static void rightRotate(int[] arr, int k) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static void leftShiftMatrixByK(int[][] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            // rotate arr[i] by k
            leftRotate(arr[i], k);
        }
    }

    private static void leftRotate(int[] arr, int k) {
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
    }

}
