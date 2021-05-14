package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

// Verified both solutions
public class YT_6_a_CheckIfBST {
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

        boolean op = isBST(binaryTree.root);

        System.out.println();

        System.out.println("solution 1 : " + op);

        op = solution2(binaryTree.root);

        System.out.println();

        System.out.println("solution 2 : " + op);
    }

    static boolean solution2(Node root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return check(root, min, max);
    }

    static boolean isBST(Node root) {
        // code here.
        List<Integer> op = new ArrayList<>();

        inorder(root, op);

        for (int i = 0; i < op.size() - 2; i++) {
            if (op.get(i) >= op.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    private static void inorder(Node root, List<Integer> op) {
        if (root == null) return;

        inorder(root.left, op);

        op.add(root.key);

        inorder(root.right, op);

    }

    private static boolean check(Node root, int min, int max) {
        if (root == null) return true;

        if (root.key < min || root.key > max) return false;

        return check(root.left, min, root.key - 1) && check(root.right, root.key + 1, max);

    }
}
