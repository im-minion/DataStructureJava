public class Q_111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.right == null && root.left == null) {
            return 1;
        }

        if (root.left != null && root.right != null) {
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            return 1 + Math.min(l, r);
        } else {
            if (root.right == null)
                return 1 + minDepth(root.left);
            else
                return 1 + minDepth(root.right);
        }
    }

}
