package matrix;

public class RotateMatrixAntiClockwise {

    public static void main(String[] args) {
        // Test Case 1
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Tese Case 2
        /* int a[][] = new int {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };*/
        rotateMatrixOwnVersion(a.length, a[0].length, a);
        MatrixUtil.printMatrix(a);

    }

    // Anticlockwise
    private static void rotateMatrixOwnVersion(int r, int c, int[][] arr) {
        int rowBegin = 0;
        int rowLength = r;
        int colBegin = 0;
        int colLength = c;

        while (rowBegin < rowLength && colBegin < colLength) {
            int prev = arr[rowLength - 1][colBegin];
            if (rowBegin + 1 == rowLength && colBegin + 1 == colLength) {
                break;
            }
            // ----->
            for (int i = colBegin; i < colLength; i++) {
                int curr = arr[rowLength - 1][i];
                arr[rowLength - 1][i] = prev;
                prev = curr;
            }
            rowLength--;

            //   up
            //   |
            //   |
            //   |
            for (int i = rowLength - 1; i >= rowBegin; i--) {
                int curr = arr[i][colLength - 1];
                arr[i][colLength - 1] = prev;
                prev = curr;
            }
            colLength--;

            // <--------
            for (int i = colLength - 1; i >= colBegin; i--) {
                int curr = arr[rowBegin][i];
                arr[rowBegin][i] = prev;
                prev = curr;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowLength; i++) {
                int curr = arr[i][colBegin];
                arr[i][colBegin] = prev;
                prev = curr;
            }
            colBegin++;

        }
    }
}
