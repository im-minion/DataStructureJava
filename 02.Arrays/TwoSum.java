import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int array[] = { 2, 7, 8, 6 };

        int result[] = twoSum(array, 9);

    }

    private static int[] twoSum(int arr[], int target) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (target == (arr[i] + arr[i + 1])) {
                result.add(i);
                result.add(1 + i);
            }
        }
        System.out.println(result);
        return null;
    }

}