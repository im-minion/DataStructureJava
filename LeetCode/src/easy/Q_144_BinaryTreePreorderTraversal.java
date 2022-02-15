import java.util.ArrayList;
import java.util.List;

public class Q_144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();

        solve(root, op);

        return op;
    }

    public static void solve(TreeNode root, List<Integer> op) {
        if (root == null) return;

        op.add(root.val);

        solve(root.left, op);

        solve(root.right, op);
    }
}
