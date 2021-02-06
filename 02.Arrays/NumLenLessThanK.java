/*
* Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.
*   Input:
	  0 1 5
	  1
	  2
	Output:
	  2 (0 and 1 are possible)
*   Input:
	  0 1 2 5
	  2
	  21
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumLenLessThanK {
    public static void main(String[] args) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(0);
        r.add(1);
        r.add(5);
        int result = solve(r, 1, 2);
        System.out.println(result);
    }

    public static int solve(ArrayList<Integer> A, int B, int C) {
        int n = A.size();
        int result = 0;

        // A = [0, 0, 1, 2, 2, 3] -> A = [0, 1, 2, 3]
        Set<Integer> aSet = new HashSet<>(A);
        A.clear();
        A.addAll(aSet);

        // C = 123  ->  cList = [1, 2, 3]
        ArrayList<Integer> cList = new ArrayList<>();
        while (C > 0) {
            cList.add(0, C % 10);
            C /= 10;
        }
        if (cList.size() < B) {
            // A = [0, 1, 2, 5]
            // B = 4
            // C = 10
            // There is no value less than 10 and which has 4 digits.
            return 0;
        }
        if (B < cList.size()) {
            // A = [1, 5, 6, 9]
            // B = 2
            // C = 101
            // "101" has 3 digits, but B is 2.
            // So we need to convert C to the maximum value of
            // the number which has 2 digits.
            C = (int) Math.pow(10, B) - 1;
            cList.clear();
            while (C > 0) {
                cList.add(0, C % 10);
                C /= 10;
            }
            if (aSet.contains(cList.get(cList.size() - 1))) {
                result = 1;  // A = [1, 5, 6, 9], B = 2, C = 99
            }
        }

        // A = [0, 1, 2, 5]
        // B = 3
        // C = 101
        // "101" has 3 digits, which equals with B.
        boolean isFirst = true;
        for (int digit : cList) {
            int cnt = 0;
            if (isFirst && B > 1) {
                for (int d : A) {
                    cnt += (d > 0 && d < digit) ? 1 : 0;
                }
            } else {
                for (int d : A) {
                    cnt += (d < digit) ? 1 : 0;
                }
            }
            isFirst = false;
            result += cnt * (int) Math.pow(n, --B);
            if (!aSet.contains(digit)) break;
        }
        return result;
    }
}
