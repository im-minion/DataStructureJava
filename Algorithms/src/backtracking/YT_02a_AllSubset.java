package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Unique Subsets
 * <p>
 * https://www.geeksforgeeks.org/problems/subsets-1587115621/1
 * <p>
 * Tested
 */
public class YT_02a_AllSubset {

    public static void main(String[] args) {
        System.out.println(AllSubsets(new int[]{1, 2, 2}, 3));
    }

    public static ArrayList<ArrayList<Integer>> AllSubsets(int[] arr, int n) {
        Set<ArrayList<Integer>> op = new HashSet<>();

        Arrays.sort(arr);

        solve(0, arr, n, op, new ArrayList<>());

        ArrayList<ArrayList<Integer>> res = new ArrayList<>(op);
        res.sort((a, b) -> {
            int n1 = a.size();
            int n2 = b.size();
            for (int i = 0; i < Math.min(n1, n2); i++) {
                int diff = a.get(i) - b.get(i);
                if (diff != 0) {
                    return diff;
                }
            }
            return n1 - n2;
        });
        return res;
    }

    static void solve(int index, int[] arr, int n, Set<ArrayList<Integer>> op, ArrayList<Integer> subSet) {
        // base cond
        if (index == n) {
            op.add(new ArrayList<>(subSet));
            return;
        }
        // recur without considering
        solve(index + 1, arr, n, op, subSet);

        // consider
        subSet.add(arr[index]);

        // recur after considering
        solve(index + 1, arr, n, op, subSet);

        // rollback consideration
        subSet.remove(subSet.size() - 1);
    }
}
