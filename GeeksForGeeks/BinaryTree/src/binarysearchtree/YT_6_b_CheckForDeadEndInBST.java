package binarysearchtree;

/*
*
Check whether BST contains Dead End

Given a Binary search Tree that contains positive integer values greater then 0.
* The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false.
* Here Dead End means, we are not able to insert any element after that node.

Examples:

Input :
               8
             /   \
           5      9
         /  \
        2    7
       /
      1

Output : Yes
Explanation : Node "1" is the dead End because after that
              we cant insert any element.

Input :
              8
            /   \
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at
              node 9.
*
* */

import introduction.BinaryTree;
import introduction.Node;

// Verified
public class YT_6_b_CheckForDeadEndInBST {
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

        boolean op = isDeadEnd(binaryTree.root);

        System.out.println();

        System.out.println(op);
    }

    public static boolean isDeadEnd(Node root) {
        //Add your code here.
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        MyKlass myKlass = new MyKlass();

        check(root, min, max, myKlass);

        return myKlass.flag;
    }

    private static void check(Node root, int min, int max, MyKlass myKlass) {
        if (root == null) return;

        if (myKlass.flag) return;

        if (root.left == null && root.right == null) {
            if (min == max || max == 1) { // max == 1 is here, why????i don't know
                myKlass.flag = true;
            }
            return;
        }

        check(root.left, min, root.key - 1, myKlass);
        check(root.right, root.key + 1, max, myKlass);
    }

    private static class MyKlass {
        boolean flag = false;
    }
}
