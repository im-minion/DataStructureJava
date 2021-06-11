package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

public class YT_10_b_ConvertBstToMinHeap {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(100);

        binaryTree.root.left = new Node(80);
        binaryTree.root.left.left = new Node(60);
        binaryTree.root.left.right = new Node(90);

        binaryTree.root.right = new Node(120);
        binaryTree.root.right.left = new Node(110);
        binaryTree.root.right.right = new Node(130);

        BinaryTree.printInorderTraversal(binaryTree.root);

        Node op = solve(binaryTree.root);

        System.out.println();

        BinaryTree.printBFS(op);
    }

    private static Node solve(Node root) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        System.out.println(inorder);

        MyKlass myKlass = new MyKlass();

        convertToPreOrder(root, inorder, myKlass);
        return root;
    }

    private static void convertToPreOrder(Node root, List<Integer> inorder, MyKlass myKlass) {
        if (root == null) {
            return;
        }

        root.key = inorder.get(++myKlass.i);
        convertToPreOrder(root.left, inorder, myKlass);
        convertToPreOrder(root.right, inorder, myKlass);
    }

    private static void getInorder(Node root, List<Integer> inorder) {
        if (root == null) return;

        getInorder(root.left, inorder);
        inorder.add(root.key);
        getInorder(root.right, inorder);
    }

    static class MyKlass {
        int i = -1;
    }
}
