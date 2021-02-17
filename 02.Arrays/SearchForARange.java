import java.util.ArrayList;
import java.util.List;

public class SearchForARange {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(4);
        A.add(4);
        A.add(4);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        ArrayList<Integer> result = searchRange(A, 4);
        System.out.println(result);
    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int n = A.size();
        int startInd = -1, endInd = -1, mid, ind;
        startInd = findleft(A, 0, n - 1, B);
        endInd = findright(A, 0, n - 1, B);
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(startInd);
        result.add(endInd);
        return result;
    }

    public static int findleft(final List<Integer> A, int left, int right, int B) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (A.get(mid) == B) {
                if (mid == 0 || A.get(mid - 1) != B) {
                    return mid;
                } else {
                    return findleft(A, left, mid - 1, B);
                }
            } else if (A.get(mid) < B) {
                return findleft(A, mid + 1, right, B);
            } else {
                return findleft(A, left, mid - 1, B);
            }
        }
        return -1;
    }

    public static int findright(final List<Integer> A, int left, int right, int B) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (A.get(mid) == B) {
                if (mid == A.size() - 1 || A.get(mid + 1) != B) {
                    return mid;
                } else {
                    return findright(A, mid + 1, right, B);
                }
            } else if (A.get(mid) < B) {
                return findright(A, mid + 1, right, B);
            } else {
                return findright(A, left, mid - 1, B);
            }
        }
        return -1;
    }
}
