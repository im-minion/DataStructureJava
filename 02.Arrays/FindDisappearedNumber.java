import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumber {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> result = findDisappeared(arr);
        result.forEach((i) -> System.out.println(i));
    }

    private static List<Integer> findDisappeared(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int val = Math.abs(arr[i]) - 1;
            if (arr[val] > 0) {
                arr[val] = -arr[val];
            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
