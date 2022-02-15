package gfg.traversal;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q13_LevelOrderSpiralTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

        System.out.println("Level Order Traversal : ");
        BinaryTree.printBFS(tree.root);

        System.out.println("Spiral Order traversal of Binary Tree is ");
        List<Integer> op = printSpiral(tree.root);

        System.out.println(op);
    }

    private static List<Integer> printSpiral(Node root) {
        List<Integer> l = new ArrayList<>();

        if (root == null) return l;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node t = s1.peek();
                s1.pop();
                l.add(t.key);
                if (t.right != null) {
                    s2.push(t.right);
                }
                if (t.left != null) {
                    s2.push(t.left);
                }
            }


            while (!s2.isEmpty()) {
                Node t = s2.peek();
                s2.pop();
                l.add(t.key);
                if (t.left != null) {
                    s1.push(t.left);
                }
                if (t.right != null) {
                    s1.push(t.right);
                }
            }


        }

        return l;
    }
}
