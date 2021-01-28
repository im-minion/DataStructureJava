import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] op = generateMatrix(4);
        for(int i = 0 ; i < op.length ; i++) {
            for(int j = 0 ; j < op[i].length ; j++) {
                System.out.print(op[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int A) {
        int[][] mat = new int[A][A];
        if (A == 1) {
            mat[0][0] = 1;
            return mat;
        }
        int rowBegin = 0;
        int rowEnd = A - 1;
        int columnBegin = 0;
        int columnEnd = A - 1;

        int count = 1;
        while (rowBegin <= rowEnd && columnBegin < columnEnd) {
            for (int i = columnBegin; i <= columnEnd; i++) {
                mat[rowBegin][i] = count++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                mat[i][columnEnd] = count++;
            }
            columnEnd--;
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    mat[rowEnd][i] = count++;
                }
            }
            rowEnd--;
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    mat[i][columnBegin] = count++;
                }
            }
            columnBegin++;
        }

        return mat;
    }


}
