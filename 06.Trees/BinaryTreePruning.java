/**
 * 
 * We are given the head node root of a binary tree, where additionally every
 * node's value is either a 0 or a 1.
 * 
 * Return the same tree where every subtree (of the given tree) not containing a
 * 1 has been removed.
 * 
 * (Recall that the subtree of a node X is X, plus every node that is a
 * descendant of X.)
 */

public class BinaryTreePruning {

    public static BTNode pruneTree(BTNode root) {
        if (root == null)
            return root;
        containsOne(root);
        if (root.right == null && root.left == null) {
            return null;
        }
        return root;
    }

    public static boolean containsOne(BTNode node) {
        if (node == null)
            return false;
        boolean leftContains = containsOne(node.left);
        boolean rightContains = containsOne(node.right);
        if (!leftContains) {
            node.left = null;
        }
        if (!rightContains) {
            node.right = null;
        }
        return node.data == 1 || leftContains || rightContains;
    }

    public static void main(String[] args) {
        System.out.println("Creating a tree.");
        BTNode root = new BTNode(0);
        root.left = new BTNode(0);
        root.right = new BTNode(1);
        root.left.left = new BTNode(0);
        root.left.right = new BTNode(0);
        root.right.left = new BTNode(0);
        root.right.right = new BTNode(1);
        System.out.println("Tree constructed.");

        BTNode result = pruneTree(root);
        System.out.println(BinaryTreeInOrderTraversal.inOrderTraversal(result));
    }
}