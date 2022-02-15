package gfg.binarysearchtree;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class YT_10_a_BSTToGreaterSumTree {
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

        int op = solve(binaryTree.root);

        System.out.println();

        System.out.println(op);
    }

    private static int solve(Node root) {
        MyKlass m = new MyKlass();
        solve(root, m);
        return m.sum;
    }

    private static void solve(Node root, MyKlass m) {
        if (root == null) return;
        solve(root.right, m);
        m.sum += root.key;
        solve(root.left, m);
    }

    static class MyKlass {
        int sum = 0;
    }
}
