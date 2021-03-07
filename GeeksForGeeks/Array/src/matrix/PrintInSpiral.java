package matrix;

import java.util.Arrays;
import java.util.List;

public class PrintInSpiral {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 }
        };
        int[] op = getInSpiralForm(mat);
        System.out.println("**************RESULT*****************");
        Arrays.stream(op).forEach(a -> System.out.print(a + " "));
    }

    private static int[] getInSpiralForm(int[][] arr) {
        int[] op = new int[arr.length * arr[0].length];
        int rowBegin = 0;
        int colBegin = 0;
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int count = 0;

        while (rowBegin < rowLen && colBegin < colLen) {
            // left to right
            for (int i = colBegin; i < colLen; i++) {
                op[count++] = arr[rowBegin][i];
            }
            rowBegin++;

            // top to bottom
            for (int i = rowBegin; i < rowLen; i++) {
                op[count++] = arr[i][colLen - 1];
            }
            colLen--;

            // right to left
            if(rowBegin < rowLen) {
                for (int i = colLen - 1; i >=colBegin; i--) {
                    op[count++] = arr[rowLen - 1][i];
                }
                rowLen--;
            }

            // bottom to top
            if(colBegin < colLen) {
                for (int i = rowLen - 1; i >= rowBegin; i--) {
                    op[count++] = arr[i][colBegin];
                }
                colBegin++;
            }
        }
        return op;
    }
}
