package gfg.traversal;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// VERIFIED SOLUTION
public class YT_07_d_K_DistanceNode {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        List<Integer> op = getKthNodes(tree.root, 1);
        System.out.println(op);
    }

    private static List<Integer> getKthNodes(Node root, int k) {
        List<Integer> op = new ArrayList<>();
        if (k == 0) {
            op.add(root.key);
            return op;
        }
        Queue<Node> queue = new LinkedList<>();


        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n == null) {
                if (queue.size() == 0)
                    return op;
                k--;
                queue.add(null);
            } else {
                if (k == 0) {
                    op.add(n.key);
                }
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }

        return op;
    }
}
