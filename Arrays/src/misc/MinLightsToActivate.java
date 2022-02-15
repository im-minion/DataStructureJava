package misc;

/*
 * There is a corridor in a Jail which is N units long. Given an array A of size N.
 * The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
 * All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
 * Initially all lights are off.
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 * A = [ 0, 0, 1, 1, 1, 0, 0, 1]. B = 3
 * Turn on the lights at 3rd and 8th index.
 * Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
 *
 * */
public class MinLightsToActivate {

    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1, 1, 0, 0, 1};
        int B = 3;
        int result = solve(A, B);
        System.out.println(result);
    }

    public static int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int mx_idx = Integer.MIN_VALUE;
            for (int j = i; j < i + B && j < n; j++) {
                if (A[j] == 1) {
                    mx_idx = j;
                }
            }
            if (mx_idx == Integer.MIN_VALUE) {
                for (int j = i; j > i - B && j >= 0; j--) {
                    if (A[j] == 1) {
                        mx_idx = Math.max(mx_idx, j);
                    }
                }
            }
            if (mx_idx == Integer.MIN_VALUE)
                return -1;
            count++;
            i = mx_idx + B - 1;
        }
        return count;
    }
}
