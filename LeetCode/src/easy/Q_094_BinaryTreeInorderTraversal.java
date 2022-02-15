import java.util.ArrayList;
import java.util.List;

public class Q_094_BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        solve(op, root);
        return op;
    }

    public static void solve(List<Integer> op, TreeNode root) {
        if (root == null) return;

        solve(op, root.left);

        op.add(root.val);

        solve(op, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}