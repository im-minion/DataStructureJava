package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

public class YT_2_b_MaxMinElement {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(100);

        binaryTree.root.left = new Node(80);
        binaryTree.root.left.left = new Node(60);
        binaryTree.root.left.right = new Node(90);

        binaryTree.root.right = new Node(120);
        binaryTree.root.right.left = new Node(110);
        binaryTree.root.right.right = new Node(130);

        binaryTree.root.right.left.right = new Node(115);

        int max = getMax(binaryTree.root);
        int min = getMin(binaryTree.root);
        System.out.println(max);
        System.out.println(min);
    }

    private static int getMin(Node root) {
        if (root == null) return -1;
        if (root.left == null) return root.key;
        return getMin(root.left);
    }

    private static int getMax(Node root) {
        if (root == null) return -1;
        if (root.right == null) return root.key;
        return getMax(root.right);
    }
}
