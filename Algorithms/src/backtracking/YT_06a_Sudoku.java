package backtracking;

public class YT_06a_Sudoku {
    static int N = 9;

    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        // add your code here
        return solve(0, 0, grid);
    }

    static boolean solve(int i, int j, int[][] grid) {
        if (i == N) return true;

        if (grid[i][j] != 0) {
            if (j == 8) {
                return solve(i + 1, 0, grid);
            } else {
                return solve(i, j + 1, grid);
            }
        }

        for (int k = 1; k <= 9; k++) {
            if (isValid(i, j, grid, k)) {
                grid[i][j] = k;

                if (j == 8) {
                    if (solve(i + 1, 0, grid)) {
                        return true;
                    }
                } else {
                    if (solve(i, j + 1, grid)) {
                        return true;
                    }
                }

                grid[i][j] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int row, int col, int[][] grid, int k) {
        if (rowValid(row, col, grid, k)
                && colValid(row, col, grid, k)
                && boxValid(row, col, grid, k)) {
            return true;
        }
        return false;
    }

    static boolean rowValid(int row, int col, int[][] grid, int k) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == k) return false;
        }
        return true;
    }

    static boolean colValid(int row, int col, int[][] grid, int k) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == k) return false;
        }
        return true;
    }

    static boolean boxValid(int row, int col, int[][] grid, int k) {

        int rowStart = 0, colStart = 0, rowEnd = N, colEnd = N, i, j;

        for (i = 0; i < 9; i = i + 3) {
            if (row >= i && row < i + 3) {
                rowStart = i;
                rowEnd = i + 3;
            }

            if (col >= i && col < i + 3) {
                colStart = i;
                colEnd = i + 3;
            }
        }

        for (i = rowStart; i < rowEnd; i++) {
            for (j = colStart; j < colEnd; j++) {
                if (grid[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid(int[][] grid) {
        // add your code here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
