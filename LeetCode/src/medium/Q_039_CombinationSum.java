package medium;

import java.util.ArrayList;
import java.util.List;

// TODO: UTS
public class Q_039_CombinationSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int sum = 0;
        solve(0, candidates, target, curr, sum, op);
        return op;
    }

    private void solve(int i, int[] candidates, int target, List<Integer> curr, int sum, List<List<Integer>> op) {
        if (sum == target) {
            op.add(curr);
            return;
        }
        if (i == candidates.length || sum > target) return;

        //
        sum += candidates[i];

        curr.add(candidates[i]);

        solve(i, candidates, target, curr, sum, op);

        sum += candidates[i];

        curr.remove(curr.size() - 1);

        //
        solve(i + 1, candidates, target, curr, sum, op);

    }
}
