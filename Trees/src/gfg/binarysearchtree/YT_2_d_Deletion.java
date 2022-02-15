package gfg.binarysearchtree;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

// TODO: Not Done. Not Working
public class YT_2_d_Deletion {
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

        System.out.println();

        Node r = delete(binaryTree.root, 60);
        BinaryTree.printInorderTraversal(r);

        System.out.println();

        r = delete(binaryTree.root, 110);
        BinaryTree.printInorderTraversal(r);

        System.out.println();

        r = delete(binaryTree.root, 120);
        BinaryTree.printInorderTraversal(r);
    }

    private static Node delete(Node root, int keyToDelete) {
        if (root == null) return root;

        if (root.key == keyToDelete) {

            // 0-child
            if (root.left == null & root.right == null) {
                return null;
            }

            // 2-child
            if (root.left != null && root.right != null) {
                // find smaller than root
                Node t = util(root.left);
                root.key = t.key;
                root.left = delete(root.left, t.key); // 1-child
                return root;
            }

            // 1-child
            if (root.left != null)
                return root.left;
            if (root.right != null)
                return root.right;
        } else if (root.key > keyToDelete) {
            root.right = delete(root.right, keyToDelete);
        } else {
            root.left = delete(root.left, keyToDelete);
        }
        return root;
    }

    static Node util(Node root) {
        Node minv = root;
        while (root.left != null) {
            minv = root.left;
            root = root.left;
        }
        return minv;
    }

}
