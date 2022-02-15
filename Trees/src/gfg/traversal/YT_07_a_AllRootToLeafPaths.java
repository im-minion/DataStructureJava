package gfg.traversal;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// TODO: Unresolved
public class YT_07_a_AllRootToLeafPaths {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        List<List<Integer>> op = getAllPathsToLeaf(tree.root);

        System.out.println(op);
    }

    private static List<List<Integer>> getAllPathsToLeaf(Node root) {
        List<List<Integer>> op = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        getPath(root, path, op);
        return op;
    }

    private static void getPath(Node root, Deque<Integer> path, List<List<Integer>> op) {

        if (root == null) return;

        path.add(root.key);

        if (root.right == null && root.left == null) {
            op.add(new ArrayList<>(path));
        }

        getPath(root.left, path, op);
        getPath(root.right, path, op);
        path.removeLast();
    }
}
