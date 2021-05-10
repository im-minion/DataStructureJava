package binarysearchtree;
/*
Given a Binary Search Tree(BST),
convert it to a Binary Tree such that every key of the original BST is changed to key plus sum of all smaller keys in BST.
Given a BST with N Nodes we have to convert into Binary Tree.

Solution: We will perform a regular Inorder traversal in which we keep track of sum of Nodes visited. Let this sum be sum.
The Node which is being visited, add that key of Node to sum i.e. sum = sum + Node->key.
Change the key of current Node to sum i.e. Node->key = sum.
When a BST is being traversed in inorder, for every key currently being visited,
all keys that are already visited are all smaller keys.
*/

import introduction.BinaryTree;
import introduction.Node;

// Verified
public class YT_3_d_BSTToTreeWithSumOfSmallerKeys {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(9);
        tree.root.left = new Node(6);
        tree.root.right = new Node(15);

        BinaryTree.printInorderTraversal(tree.root);

        System.out.println();

        MyKlass myKlass = new MyKlass();

        getNoOfNodesInRange(tree.root, myKlass);

        BinaryTree.printInorderTraversal(tree.root);
    }

    private static void getNoOfNodesInRange(Node root, MyKlass myKlass) { // doing inorder traversal as per the need
        if (root == null) return;

        getNoOfNodesInRange(root.left, myKlass);

        myKlass.sum += root.key;
        root.key = myKlass.sum;

        getNoOfNodesInRange(root.right, myKlass);
    }

    private static class MyKlass {
        int sum = 0;
    }
}
