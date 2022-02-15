package misc;

/*
 * Problem Description
 * Given an integer array A of size N.
 * You need to check that whether there exist a element which is strictly greater than all the elements on
 * left of it and strictly smaller than all the elements on right of it.
 * If it exists return 1 else return 0.
 *
 * Input : A = [5, 1, 4, 3, 6, 8, 10, 7, 9] Output : 1
 * Explanation 1:
 * A[4] = 6 is the element we are looking for.
 * All elements on left of A[4] are smaller than it and all elements on right are greater.
 * */
public class PerfectPeakElement {
    public static void main(String[] args) {
        int[] A = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int result = perfectPeak(A);
        System.out.println(result);
    }

    public static int perfectPeak(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            int curr = A[i];
            boolean leftSide = true;
            boolean rightSide = true;
            for (int j = 0; j < i; j++) {
                if (A[j] >= curr) {
                    leftSide = false;
                    break;
                }
            }

            for (int k = i + 1; k < A.length; k++) {
                if (A[k] <= curr) {
                    rightSide = false;
                    break;
                }
            }
            if (leftSide && rightSide) {
                return 1;
            }
        }
        return 0;
    }
}
