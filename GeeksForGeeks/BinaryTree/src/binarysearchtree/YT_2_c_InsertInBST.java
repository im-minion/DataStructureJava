package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

public class YT_2_c_InsertInBST {
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

        Node r = insert(binaryTree.root, 70);
        BinaryTree.printInorderTraversal(r);
    }

    private static Node insert(Node root, int i) {
        if (root == null) return root;
        insertNode(root, i);
        return root;
    }

    private static void insertNode(Node root, int i) {
        if (root.key < i) {
            if (root.right == null) {
                root.right = new Node(i);
                return;
            } else {
                insertNode(root.right, i);
            }
        } else if (root.key > i) {
            if (root.left == null) {
                root.left = new Node(i);
                return;
            } else {
                insertNode(root.left, i);
            }
        } else {
            // equals
            Node t = root.right;
            root.right = new Node(i);
            root.right.right = t;
            return;
        }
    }
}
