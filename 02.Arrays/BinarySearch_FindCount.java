/*
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return 2.
 * */

import java.util.ArrayList;
import java.util.List;

public class BinarySearch_FindCount {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(8);
        A.add(10);
        int result = findCount(A, 8);
        System.out.println(result);
    }

    public static int findCount(final List<Integer> A, int B) {
        int n = A.size();
        return bin_search(A, B, 0, n - 1);

    }

    public static int bin_search(final List<Integer> A, int B, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A.get(mid) == B) {
                // found at index mid
                return 1 + bin_search(A, B, mid + 1, high) + bin_search(A, B, low, mid - 1);

            } else if (A.get(mid) > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
