package easy;

import util.TreeNode;

public class Q_104_MaxDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
