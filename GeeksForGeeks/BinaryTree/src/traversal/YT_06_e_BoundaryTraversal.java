package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

public class YT_06_e_BoundaryTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        List<Integer> op = getBoundaryTraversal(tree.root);

        System.out.println(op);
    }

    private static List<Integer> getBoundaryTraversal(Node root) {
        List<Integer> op = new ArrayList<>();

        Node n = root;

        op.add(n.key);
        // LeftBoundary
        getLeftBoundary(n.left, op);

        // Leaf
        getLeafBoundary(n, op);

        // RightBoundary
        getRightBoundary(n.right, op);

        return op;
    }

    private static void getLeftBoundary(Node n, List<Integer> op) {
        if (n == null) return;
        if (n.left != null || n.right != null) {
            op.add(n.key);
            if (n.left != null) {
                getLeftBoundary(n.left, op);
            } else {
                getLeftBoundary(n.right, op);
            }
        }
    }

    private static void getRightBoundary(Node n, List<Integer> op) {
        if (n == null) return;
        if (n.left != null || n.right != null) {
            if (n.right != null) {
                getRightBoundary(n.right, op);
            } else {
                getRightBoundary(n.left, op);
            }
            op.add(n.key);
        }
    }

    private static void getLeafBoundary(Node n, List<Integer> op) { // inorder but printing only if node is leaf
        if (n == null) return;

        getLeafBoundary(n.left, op);

        if (n.left == null && n.right == null) {
            op.add(n.key);
        }

        getLeafBoundary(n.right, op);
    }
}
