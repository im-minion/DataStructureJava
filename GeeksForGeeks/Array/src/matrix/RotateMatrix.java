package matrix;

public class RotateMatrix {
    public static void main(String[] args) {
        // Test Case 1
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int R = 4;
        int C = 4;
        // Tese Case 2
        /* int a[][] = new int {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };*/
        rotateMatrix(R, C, a);
        MatrixUtil.printMatrix(a);

    }

    private static void rotateMatrix(int r, int c, int[][] arr) {
        int rowBegin = 0;
        int rowEnd = r;
        int colBegin = 0;
        int colEnd = c;
        int prev, curr;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // 00 => 01
            if (rowBegin + 1 == rowEnd || colBegin + 1 == colEnd)
                break;
            prev = arr[rowBegin + 1][colBegin];

            // Move elements of first row from the remaining rows
            for (int i = colBegin; i < colEnd; i++) {
                curr = arr[rowBegin][i];
                arr[rowBegin][i] = prev;
                prev = curr;
            }
            rowBegin++;

            // Move elements of last column from the remaining columns
            for (int i = rowBegin; i < rowEnd; i++) {
                curr = arr[i][colEnd - 1];
                arr[i][colEnd - 1] = prev;
                prev = curr;
            }
            colEnd--;

            // Move elements of last row from the remaining rows
            if (rowBegin < rowEnd) {
                for (int i = colEnd - 1; i >= colBegin; i--) {
                    curr = arr[rowEnd - 1][i];
                    arr[rowEnd - 1][i] = prev;
                    prev = curr;
                }
            }
            rowEnd--;

            // Move elements of first column from the remaining rows
            if (colBegin < colEnd) {
                for (int i = rowEnd - 1; i >= rowBegin; i--) {
                    curr = arr[i][colBegin];
                    arr[i][colBegin] = prev;
                    prev = curr;
                }
            }
            colBegin++;
        }

        // Print rotated matrix
//        for (int i = 0; i < R; i++)
//        {
//            for (int j = 0; j < C; j++)
//                System.out.print( arr[i][j] + " ");
//            System.out.print("\n");
//        }

//    }

    }
}
