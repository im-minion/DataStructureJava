package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

// Verified
public class YT_9_a_LargestBstInBT {
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

        int size = solve(binaryTree.root);

        System.out.println(size);
    }

    private static int solve(Node root) {
        MyKlass m = solveThis(root);
        return m.size;
    }

    private static MyKlass solveThis(Node root) {
        if (root == null) {
            return new MyKlass(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        MyKlass left = solveThis(root.left);
        MyKlass right = solveThis(root.right);
        if (left.isBst && right.isBst && right.min > root.key && left.max < root.key) {
            return new MyKlass(true, 1 + left.size + right.size, Math.min(root.key, left.min), Math.max(root.key, right.max));
        }
        return new MyKlass(false, Math.max(left.size, right.size), -1, -1);
    }

    static class MyKlass {
        boolean isBst;
        int size;
        int min;
        int max;

        public MyKlass(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
