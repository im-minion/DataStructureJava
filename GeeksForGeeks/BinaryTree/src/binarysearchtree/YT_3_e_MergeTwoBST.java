package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

/*
Given two BSTs, return elements of both BSTs in sorted form.

Input:

BST1:
           5
         /   \
        3     6
       / \
      2   4
BST2:
          2
        /   \
       1     3
              \
               7
              /
             6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation:
After merging and sorting the
two BST we get 1 2 2 3 3 4 5 6 6 7.

*/
public class YT_3_e_MergeTwoBST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(4);
        BinaryTree.printInorderTraversal(tree.root);

        System.out.println();

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(2);
        tree2.root.left = new Node(1);
        tree2.root.right = new Node(3);
        tree2.root.right.right = new Node(7);
        tree2.root.right.right.left = new Node(6);
        BinaryTree.printInorderTraversal(tree2.root);

        List<Integer> op = solve(tree.root, tree2.root);
        System.out.println(op);
    }

    private static List<Integer> solve(Node root1, Node root2) {
        List<Integer> data1 = new ArrayList<>();
        getInorder(root1, data1);

        List<Integer> data2 = new ArrayList<>();
        getInorder(root2, data2);

        List<Integer> op = new ArrayList<>();
        merge(data1, data2, op);
        return op;
    }

    private static void merge(List<Integer> data1, List<Integer> data2, List<Integer> op) {
        int n1 = data1.size();
        int n2 = data2.size();
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (data1.get(i) < data2.get(j)) {
                op.add(data1.get(i));
                i++;
            } else if (data1.get(i) > data2.get(j)) {
                op.add(data2.get(j));
                j++;
            } else {
                op.add(data1.get(i));
                op.add(data2.get(j));
                i++;
                j++;
            }
        }

        while (i < n1) {
            op.add(data1.get(i));
            i++;
        }

        while (j < n2) {
            op.add(data2.get(j));
            j++;
        }
    }

    private static void getInorder(Node root, List<Integer> data) {
        if (root == null) return;

        if (root.left != null) getInorder(root.left, data);

        data.add(root.key);

        if (root.right != null) getInorder(root.right, data);
    }
}
