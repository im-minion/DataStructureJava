package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

public class YT_5_a_LcaOfBST {
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

        Node lca = LCA(binaryTree.root, 110, 80);

        System.out.println();

        System.out.println(lca.key);
    }

    public static Node LCA(Node root, int n1, int n2) {
        // code here.
        if (root == null) return root;

        if (root.key == n1 || root.key == n2) {
            return root;
        }

        if (root.key < n1 && root.key < n2) {
            return LCA(root.right, n1, n2);
        }
        if (root.key > n1 && root.key > n2) {
            return LCA(root.left, n1, n2);
        }

        return root;
    }
}
