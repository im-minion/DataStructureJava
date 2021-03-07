package matrix;

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
