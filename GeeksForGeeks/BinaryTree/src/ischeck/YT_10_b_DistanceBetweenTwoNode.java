package ischeck;

import introduction.BinaryTree;
import introduction.Node;

// TODO: Hard One, but good one
public class YT_10_b_DistanceBetweenTwoNode {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int dist = distanceBetweenTwoNode(tree.root, 4, 5);
        System.out.println(dist);
    }

    private static int distanceBetweenTwoNode(Node root, int a, int b) {
        Node lcaNode = lca(root, a, b);
        if (lcaNode == null) return 0;
        return findLevel(lcaNode, a, 0) + findLevel(lcaNode, b, 0);
    }

    private static int findLevel(Node lcaNode, int x, int level) {
        if (lcaNode == null) return -1;
        if (lcaNode.key == x) return level;
        int left = findLevel(lcaNode.left, x, level + 1);
        if (left == -1) {
            return findLevel(lcaNode.right, x, level + 1);
        }
        return left;
    }

    private static Node lca(Node root, int a, int b) {
        if (root == null) return root;

        if (root.key == a || root.key == b) return root;

        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);

        if (l != null && r != null) return root;

        if (l != null) return l;

        if (r != null) return r;

        return null;
    }

}
