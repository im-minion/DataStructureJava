package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.*;

/*
Vertical Traversal of Binary Tree

Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:
Input:
        2
         \
          3
         /
        4
Output: 2 4 3


Example 2:
Input:
        1
     /    \
    2      3
  /   \     \
 4     5     6
Output: 4 2 1 5 3 6*/
public class VerticalTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.right = new Node(6);

        printVerticalOrder(tree.root);
    }

    private static void printVerticalOrder(Node root) {
        if (root == null)
            return;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int hd = 0;

        Queue<Qobj> queue = new LinkedList<>();
        queue.add(new Qobj(0, root));

        while (!queue.isEmpty()) {
            Qobj t = queue.poll();

            hd = t.hd;
            Node node = t.node;

            if (m.containsKey(hd)) {
                m.get(hd).add(node.key);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(node.key);
                m.put(hd, temp);
            }

            if (node.left != null) {
                queue.add(new Qobj(hd - 1, node.left));
            }

            if (node.right != null) {
                queue.add(new Qobj(hd + 1, node.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            for (Integer i : al)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

class Qobj {
    int hd;
    Node node;

    Qobj(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}
