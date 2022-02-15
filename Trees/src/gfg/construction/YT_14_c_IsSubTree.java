package gfg.construction;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO : Giving StackOverflow on GeeksForGeeks.
public class YT_14_c_IsSubTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(44);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(2);

        tree2.root.left = new Node(4);
        tree2.root.right = new Node(5);

        boolean op = isSubtree(tree.root, tree2.root);
        System.out.println(op);
    }

    public static boolean isSubtree(Node root, Node root1) {
        List<Integer> op = new ArrayList<>();
        serialize(root, op);
        List<Integer> i = op;
        // System.out.println(i);

        op = new ArrayList<>();
        serialize(root1, op);
        List<Integer> j = op;
        // System.out.println(j);
        return Collections.indexOfSubList(i, j) != -1 || Collections.indexOfSubList(j, i) != -1;
    }

    private static void serialize(Node root, List<Integer> op) {
        if (root == null) {
            op.add(-1);
            return;
        }
        op.add(root.key);
        serialize(root.left, op);
        serialize(root.right, op);
    }
}
