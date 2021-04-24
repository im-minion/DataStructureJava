package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

// Verified
public class YT_3_b_RangeInBst {
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

        System.out.println();
        int count = getNoOfNodesInRange(binaryTree.root, 70, 110);

        System.out.println(count);
    }

    private static int getNoOfNodesInRange(Node root, int i, int j) {
        MyClass myClass = new MyClass();
        solve(root, i, j, myClass);
        return myClass.count;
    }

    private static void solve(Node root, int i, int j, MyClass myClass) {
        if (root == null) return;

        if (i <= root.key && root.key <= j) {
            myClass.count++;
            solve(root.right, i, j, myClass);
            solve(root.left, i, j, myClass);
        }

        if (root.key < i)
            solve(root.right, i, j, myClass);

        if (root.key > j)
            solve(root.left, i, j, myClass);

    }

    private static class MyClass {
        int count = 0;
    }
}
