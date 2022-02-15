package gfg.traversal;

import gfg.introduction.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q14_LevelOrderTraversalLineLineOneQueue {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);


        List<List<Integer>> op = levelOrderLineByLine(root);
        System.out.println(op);
    }

    private static List<List<Integer>> levelOrderLineByLine(Node root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> temp = new ArrayList<>();
        while (!q.isEmpty()) {

            Node t = q.peek();
            q.poll();
            if (t == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    l.add(temp);
                    System.out.println();
                    temp = new ArrayList<>();
                }
            } else {
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
                System.out.print(t.key + " ");
                temp.add(t.key);
            }
        }
        l.add(temp);
        System.out.println();
        return l;
    }
}
