package easy;/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
*/

public class Q_110_IsBalancedBT {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        MyKlass m = new MyKlass();
        getHeight(root, m);
        return m.op;
    }

    public static int getHeight(TreeNode root, MyKlass m) {
        if (root == null) return 0;


        int l = getHeight(root.left, m);

        int r = getHeight(root.right, m);

        if (Math.abs(l - r) > 1) {
            m.op = false;
        }

        return 1 + Math.max(l, r);
    }

    static class MyKlass {
        boolean op = true;
    }
}
