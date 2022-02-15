package gfg.ischeck;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class YT_08_a_IdenticalTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);


        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(2);
        tree2.root.left.left = new Node(3);
        tree2.root.left.right = new Node(4);
        tree2.root.right.left = new Node(4);
        tree2.root.right.right = new Node(3);

        boolean output = isIdentical(tree.root, tree2.root);
        System.out.println(output);
        System.out.println(isIdentical2(tree.root, tree2.root));
    }

    private static boolean isIdentical2(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.key != root2.key) return false;

        return isIdentical2(root1.left, root2.left) && isIdentical2(root1.right, root2.right);
    }

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null) {
            if (root1.key == root2.key) {
                return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
