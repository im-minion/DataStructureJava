package gfg.matrix;

/*
Input =>
1    2    3    4
5    6    7    8
9    10    11    12

Output =>
9    5    1
10    6    2
11    7    3
12    8    4
*/

public class RotateImageBy90 {
    public static void main(String[] args) {
        int[][] image = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        rotateBy90(image);
    }

    private static void rotateBy90(int[][] image) {
        for (int i = 0; i < image[0].length; i++) {
            for (int j = image.length - 1; j >= 0; j--) {
                System.out.print(image[j][i] + " ");
            }
            System.out.println();
        }
    }
}
