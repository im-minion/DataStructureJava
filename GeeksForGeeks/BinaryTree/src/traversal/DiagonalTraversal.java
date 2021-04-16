package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {
    public static void main(String[] args) {
        /*Node Insertion*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        printDiagonalTraversal(tree.root);
    }

    private static void printDiagonalTraversal(Node root) {
        if (root == null)
            return;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        preorder(root, m, 0);

        System.out.println(m);

        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            for (Integer i : al)
                System.out.print(i + " ");
            System.out.println();
        }

    }

    private static void preorder(Node root, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
        if (!map.containsKey(hd)) {
            ArrayList<Integer> t = new ArrayList<>();
            t.add((root.key));
            map.put(hd, t);
        } else {
            map.get(hd).add(root.key);
        }

        if (root.left != null) preorder(root.left, map, hd + 1);
        if (root.right != null) preorder(root.right, map, hd);
    }
}
