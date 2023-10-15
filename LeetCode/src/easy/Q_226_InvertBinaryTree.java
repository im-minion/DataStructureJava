package easy;

import util.TreeNode;

public class Q_226_InvertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        root.right = invertTree(root.right);
        root.left = invertTree(root.left);

        return root;

    }
}
