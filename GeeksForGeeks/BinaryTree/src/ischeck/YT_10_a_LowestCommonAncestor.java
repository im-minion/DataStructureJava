package ischeck;

import introduction.BinaryTree;
import introduction.Node;

// Verified
public class YT_10_a_LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lcaNode = lca(tree.root, 4, 5);
        System.out.println(lcaNode.key);
    }

    static Node lca(Node root, int n1, int n2) {
        // Your code here

        if (root == null) return root;

        if (root.key == n1 || root.key == n2) return root;

        Node l = lca(root.left, n1, n2);
        Node r = lca(root.right, n1, n2);

        if (l != null && r != null) return root;

        if (l != null) return l;

        if (r != null) return r;

        return null;
    }
}
