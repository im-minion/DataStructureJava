package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

public class Q06_AllPossibleTreesFromInorder {
    public static void main(String[] args) {
        int[] in = {4, 5, 7};
        int n = in.length;
        List<Node> trees = getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different " +
                " binary trees are:");
        for (Node node : trees) {
            BinaryTree.printBFS(node);
            System.out.println();
        }
    }

    private static List<Node> getTrees(int[] in, int start, int end) {
        List<Node> tr = new ArrayList<>();
        if (start > end) {
            tr.add(null);
            return tr;
        }

        for (int i = start; i <= end; i++) {
            List<Node> leftTree = getTrees(in, start, i - 1);
            List<Node> rightTree = getTrees(in, i + 1, end);
            for (Node value : leftTree) {
                for (Node item : rightTree) {
                    Node node = new Node(in[i]);

                    // Connecting left subtree
                    node.left = value;

                    // Connecting right subtree
                    node.right = item;

                    // Adding this tree to list
                    tr.add(node);
                }
            }
        }

        return tr;
    }
}
