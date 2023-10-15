package easy;

import java.util.ArrayList;
import java.util.List;

public class Q_145_BinaryTreePostOrderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        int a = op.stream().min(Integer::compare).isPresent() ? op.stream().min(Integer::compare).get() : -1;
        solve(root, op);

        return op;
    }

    public static void solve(TreeNode root, List<Integer> op) {
        if (root == null) return;

        solve(root.left, op);

        solve(root.right, op);

        op.add(root.val);
    }
}
