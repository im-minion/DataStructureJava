package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

import java.util.Arrays;
import java.util.List;

// Verified

public class YT_3_c_SortedDataToBST {
    public static void main(String[] args) {
        List<Integer> in = Arrays.asList(10, 12, 15, 20, 24, 28);

        Node root = getTree(in, 0, in.size() - 1);

        BinaryTree.printInorderTraversal(root);

    }

    private static Node getTree(List<Integer> in, int l, int h) {
        if (l <= h) {
            int mid = (l + h) / 2;
            Node root = new Node(in.get(mid));

            root.left = getTree(in, l, mid - 1);
            root.right = getTree(in, mid + 1, h);

            return root;
        } else {
            return null;
        }
    }
}
