package misc;

public class RotateTranspose {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
        int arrTranspose[][] = transpose(arr);
        for (int i = 0; i < arrTranspose.length; i++) {
            for (int j = 0; j < arrTranspose[i].length; j++) {
                System.out.print(arrTranspose[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static int[][] transpose(int[][] arr) {
        // swap i,j => j,i
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }
}