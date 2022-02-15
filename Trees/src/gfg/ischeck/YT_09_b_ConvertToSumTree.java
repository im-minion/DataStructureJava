package gfg.ischeck;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;
// Verified
public class YT_09_b_ConvertToSumTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        toSumTree(tree.root);
        BinaryTree.printBFS(tree.root);
    }

    public static void toSumTree(Node root) {
        //add code here.
        if (root == null) return;
        transform(root);
    }

    static int transform(Node root) {
        // TODO: Understand this we have to go from bottom up so
        // First => evaluate the left part and right part with recursive calls
        // Then perform the operation
        if (root == null) return 0;
        int l = transform(root.left);
        int r = transform(root.right);
        int currVal = l + r + root.key;
        root.key = l + r;
        return currVal;
    }
}
