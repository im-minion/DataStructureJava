package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

public class YT_7_b_ClosestElementInBST {
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

        BinaryTree.printInorderTraversal(binaryTree.root);

        int op = minDiff(binaryTree.root, 140);

        System.out.println();

        System.out.println(op);
    }

    static int minDiff(Node root, int K) {
        // Write your code here
        if (root == null) return Integer.MAX_VALUE;

        if (root.key == K) return 0;

        if (root.key > K) {
            return Math.min(Math.abs(root.key - K), minDiff(root.left, K));
        } else {
            return Math.min(Math.abs(root.key - K), minDiff(root.right, K));
        }
    }
}
