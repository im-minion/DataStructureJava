package gfg.orderstatistics;

public class MaxMinWithMinComparisons {
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int[] minMax = getMinMax(arr);
        System.out.println("Min::" + minMax[0]);
        System.out.println("Max::" + minMax[1]);
    }

    private static int[] getMinMax(int[] arr) {
        int[] op = new int[2];
        if (arr.length == 0) return op;
        if (arr.length == 1) {
            op[0] = arr[0];
            op[1] = arr[0];
        } else {
            if (arr[0] < arr[1]) {
                op[0] = arr[0];
                op[1] = arr[1];
            } else {
                op[0] = arr[1];
                op[1] = arr[0];
            }
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] > op[1]) { //arr[i] > max
                    op[1] = arr[i];
                } else if (arr[i] < op[0]) { //arr[i] < min
                    op[0] = arr[i];
                }
            }
        }
        return op;
    }
}
