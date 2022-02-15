package misc;

/*
 * You are in an infinite 2D grid where you can move in any of the 8 directions.
 * You are given a sequence of points and the order in which you need to cover the points..
 * Give the minimum number of steps in which you can achieve it.
 * You start from the first point
 *
 * Input 1:
 * A = [0, 1, 1]
 * B = [0, 1, 2]
 * Example Output
 * Output 1:
 * 2
 *
 * Given three points are: (0, 0), (1, 1) and (1, 2).
 * It takes 1 step to move from (0, 0) to (1, 1).
 * It takes one more step to move from (1, 1) to (1, 2).
 * */
public class CoverPoints {
    public static void main(String[] args) {
        int[] A = {0, 1, 1};
        int[] B = {0, 1, 2};
        int result = coverPoints(A, B);
        System.out.println(result);
    }

    public static int coverPoints(int[] A, int[] B) {
        int steps = 0;

        for (int i = 0; i < A.length - 1; i++) {
            steps += Math.max(Math.abs(A[i] - A[i + 1]), Math.abs(B[i] - B[i + 1]));
        }
        return steps;
    }
}
