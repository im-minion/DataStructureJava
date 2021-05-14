package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

// Verified
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

        System.out.println();

        System.out.println(kthSmallest);
    }

    private static int solve(Node root, int k) {
        MyKlass myKlass = new MyKlass();
        myKlass.k = k;
        inorder(root, myKlass);
        return myKlass.val;
    }

    private static void inorder(Node root, MyKlass myKlass) {
        if (root == null) return;
        if (myKlass.k <= 0) return;
        inorder(root.left, myKlass);
        myKlass.k--;
        if (myKlass.k == 0) {
            myKlass.val = root.key;
            return;
        }
        inorder(root.right, myKlass);
    }

    public static class MyKlass {
        int val = -1;
        int k;
    }
}
