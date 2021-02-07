/*

Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.
* Input 1:
    A = [4, 5, 6, 7, 0, 1, 2, 3]
    B = 4
Output 1:
    0
Explanation 1:
 Target 4 is found at index 0 in A.


Input 2:
    A = [5, 17, 100, 3]
    B = 6
Output 2:
    -1
* */

import java.util.ArrayList;
import java.util.List;

public class BinarySearch_RotatedSortedArray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(3);
        int result = search(A, 4);
        System.out.println(result);
    }

    public static int search(final List<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a.get(mid) == b)
                return mid;
            if (a.get(mid) >= a.get(low)) {
                if (b >= a.get(low) && b < a.get(mid))
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (b > a.get(mid) && b <= a.get(high))
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
