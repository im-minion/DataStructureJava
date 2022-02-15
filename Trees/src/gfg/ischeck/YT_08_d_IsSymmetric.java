package gfg.ischeck;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class YT_08_d_IsSymmetric {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = isSymmetric(tree.root);
        System.out.println(output);
    }

    private static boolean isSymmetric(Node root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.key != root2.key) return false;

        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
