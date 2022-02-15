package gfg.ischeck;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class YT_08_c_IsMirror {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(2);

        tree2.root.left = new Node(4);
        tree2.root.right = new Node(5);

        boolean op = isMirror(tree.root, tree2.root);
        System.out.println(op);
    }

    private static boolean isMirror(Node root, Node root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        if (root.key != root1.key) {
            return false;
        }

        return isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }
}
