package gfg.binarysearchtree;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class BST {
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

        boolean op = search(binaryTree.root, 110);
        System.out.println(op);
    }

    private static boolean search(Node root, int key) {
        if (root == null) return false;

        if (root.key == key) return true;

        if (root.key < key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}