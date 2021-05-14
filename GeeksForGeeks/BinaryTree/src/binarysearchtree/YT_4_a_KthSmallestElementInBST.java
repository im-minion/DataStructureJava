package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

public class YT_4_a_KthSmallestElementInBST {
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

        int kthSmallest = solve(binaryTree.root, 3);
    }

    private static int solve(Node root, int k) {

        return 0;
    }
}
