package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Verified!!
public class YT_3_a_BinaryTreeToBST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Before");
        BinaryTree.printInorderTraversal(tree.root);

        convertToBst(tree.root);

        System.out.println("\nAfter");
        BinaryTree.printInorderTraversal(tree.root);
    }

    private static void convertToBst(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        getInorder(root, inOrder);
//        System.out.println(inOrder);
        Collections.sort(inOrder);
        MyKlass myKlass = new MyKlass();
        fixWithInorder(root, inOrder, myKlass);
    }

    private static void fixWithInorder(Node root, List<Integer> inOrder, MyKlass myKlass) {
        if (root == null) return;

        if (root.left != null) fixWithInorder(root.left, inOrder, myKlass);

        if (root.key != inOrder.get(myKlass.pos)) {
            root.key = inOrder.get(myKlass.pos);
            myKlass.pos++;
        } else {
            myKlass.pos++;
        }

        if (root.right != null) fixWithInorder(root.right, inOrder, myKlass);
    }

    private static class MyKlass {
        int pos = 0;
    }

    private static void getInorder(Node root, List<Integer> op) {
        if (root == null) return;
        if (root.left != null) getInorder(root.left, op);

        op.add(root.key);

        if (root.right != null) getInorder(root.right, op);
        return;
    }
}
