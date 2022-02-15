package gfg.traversal;

/*
Find postorder traversal of BST from preorder traversal
Difficulty Level : Hard
Last Updated : 15 Dec, 2020
Given an array representing preorder traversal of BST, print its postorder traversal.

Examples:

Input : 40 30 35 80 100
Output : 35 30 100 80 40

Input : 40 30 32 35 80 90 100 120
Output : 35 32 30 120 100 90 80 40
*/

public class Q05_PostOrderTraversalOfBSTFromPreOrder {
    public static void main(String[] args) {
        int[] pre = {40, 30, 35, 80, 100};
        int n = pre.length;

        // Calling function
        findPostOrder(pre, n);
    }

    private static void findPostOrder(int[] pre, int n) {
        int pivotPoint = 0;

        // run loop from 1 to length of pre
        for (int i = 1; i < pre.length; i++) {
            if (pre[0] <= pre[i]) {
                pivotPoint = i;
                break;
            }
        }

        // print from pivot length -1 to zero
        for (int i = pivotPoint - 1; i > 0; i--) {
            System.out.print(pre[i] + " ");
        }

        // print from end to pivot length
        for (int i = pre.length - 1; i >= pivotPoint; i--) {
            System.out.print(pre[i] + " ");
        }

        System.out.print(pre[0]);
    }
}
