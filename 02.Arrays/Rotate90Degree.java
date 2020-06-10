public class Rotate90Degree {
    // ROTATE IMAGE 90 degree CLOCKWISE
    public static void main(String[] args) {
        // Transpose => swap i,j with j,i
        // Flip Horizontally => swap i,j with length-1-j
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
        int arrTranspose[][] = RotateTranspose.transpose(arr);
        for (int i = 0; i < arrTranspose.length; i++) {
            for (int j = 0; j < arrTranspose[i].length / 2; j++) {
                int temp = arrTranspose[i][j];
                arrTranspose[i][j] = arrTranspose[i][arrTranspose.length - 1 - j];
                arrTranspose[i][arrTranspose.length - 1 - j] = temp;
            }
        }

        for (int i = 0; i < arrTranspose.length; i++) {
            for (int j = 0; j < arrTranspose[i].length; j++) {
                System.out.print(arrTranspose[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }
}