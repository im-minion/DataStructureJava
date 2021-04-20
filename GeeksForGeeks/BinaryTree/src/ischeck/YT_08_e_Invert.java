package ischeck;

import introduction.BinaryTree;
import introduction.Node;

import javax.swing.*;

public class YT_08_e_Invert {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        BinaryTree.printBFS(tree.root);

        // This also works
//        invertTree(tree.root);

        invertTree2(tree.root);

        BinaryTree.printBFS(tree.root);
    }

    private static void invertTree2(Node root) {
        if (root == null) return;
        Node t = root.left;
        root.left = root.right;
        root.right = t;
        if (root.left != null) invertTree2(root.left);
        if (root.right != null) invertTree2(root.right);

    }

    private static void invertTree(Node root) {
        if (root == null) return;

        invert(root, root.left, root.right);
    }

    private static void invert(Node p, Node left, Node right) {
        p.right = left;
        p.left = right;
        if (p.left != null) invert(p.left, p.left.left, p.left.right);
        if (p.right != null) invert(p.right, p.right.left, p.right.right);
    }
}
