package matrix;

public class MatrixUtil {
    // Function for print matrix
    static void printMatrix(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length;
                 j++)
                System.out.print(ints[j] + " ");
            System.out.println("");
        }
    }
}
