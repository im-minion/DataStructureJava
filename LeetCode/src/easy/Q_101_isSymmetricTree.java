public class Q_101_isSymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return solve(root.left, root.right);
    }

    public static boolean solve(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val == right.val) {
            return solve(left.left, right.right) && solve(left.right, right.left);
        } else {
            return false;
        }
    }
}
