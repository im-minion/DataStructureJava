import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] data, int target) {
        // sorting before or after the initial result doesn't make any difference.
        // Because we are gonna explore,
        // all the possibilities anyhow. If the currentSum is closeFr than the old
        // result
        // then we are gonna update the
        // result anyway. So, sorting before or after the intial result doesn't make any
        // difference.

        int result = data[0] + data[1] + data[data.length - 1];

        Arrays.sort(data);
        // Go upto length-2 because we need to fit three pointers.
        for (int i = 0; i < data.length - 2; i++) {
            int left = i + 1;
            int right = data.length - 1;

            while (left < right) {
                int currentSum = data[i] + data[left] + data[right];
                if (result > target) {
                    // try moving towards smaller values to decrease the sum.
                    right--;
                } else {
                    // try moving towards bigger values to increase the sum.
                    left++;
                }
                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Three sum closest solution.");
        int[] data = new int[] { -1, 2, 1, -4 };
        int sum = threeSumClosest(data, 1);
        System.out.println("Closest three sum " + sum);
    }
}
