package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;
// Verified
public class YT_3_d_BSTToTreeWithSumOfSmallerKeys {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(9);
        tree.root.left = new Node(6);
        tree.root.right = new Node(15);

        BinaryTree.printInorderTraversal(tree.root);

        System.out.println();

        MyKlass myKlass = new MyKlass();

        getNoOfNodesInRange(tree.root, myKlass);

        BinaryTree.printInorderTraversal(tree.root);
    }

    private static void getNoOfNodesInRange(Node root, MyKlass myKlass) {
        if (root == null) return;

        getNoOfNodesInRange(root.left, myKlass);

        myKlass.sum += root.key;
        root.key = myKlass.sum;

        getNoOfNodesInRange(root.right, myKlass);
    }

    private static class MyKlass {
        int sum = 0;
    }
}
