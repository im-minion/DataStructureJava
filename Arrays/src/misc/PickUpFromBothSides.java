package misc;

public class PickUpFromBothSides {
    public static void main(String[] args) {
        int[] Arr = {10, 20, 30, 40, 20};
        int B = 2;
        int result = solve(Arr, B);
        System.out.println(result);
    }

    public static int solve(int[] A, int B) {
        int result = 0;
        int i = 0;
        for (i = 0; i < B; i++) {
            result += A[i];
        }
        int leftSum = result;
        int rightSum = 0;
        i = A.length - 1;
        int leftIterIndex = B - 1;
        while (leftIterIndex >= 0) {
            rightSum += A[i];
            leftSum -= A[leftIterIndex];
            result = Math.max(leftSum + rightSum, result);
            leftIterIndex--;
            i--;
        }
        return result;
    }
}
