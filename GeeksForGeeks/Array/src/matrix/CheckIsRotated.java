package matrix;

public class CheckIsRotated {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {4, 1, 2, 3},
                {3, 4, 1, 2},
                {2, 3, 4, 1}
        };
        boolean result = isRotated(arr);
        System.out.println(result);
    }

    private static boolean isRotated(int[][] arr) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            a.append(arr[0][i]);
        }
        for (int[] ints : arr) {
            StringBuilder x = new StringBuilder();
            for (int j = 0; j < ints.length; j++) {
                x.append(ints[j]);
            }
            if (!(x.toString() + x.toString()).contains(a.toString())) {
                return false;
            }
        }
        return true;
    }
}
