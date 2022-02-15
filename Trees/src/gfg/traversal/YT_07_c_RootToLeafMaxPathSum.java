package gfg.traversal;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class YT_07_c_RootToLeafMaxPathSum {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        List<Integer> op = getMaxSumPath(tree.root);

        System.out.println(op);
    }

    private static List<Integer> getMaxSumPath(Node root) {
        MyClass m = new MyClass();
        Deque<Integer> deque = new ArrayDeque<>();
        findMaxPath(root, deque, m);
        return m.maxPath;
    }

    private static void findMaxPath(Node root, Deque<Integer> deque, MyClass m) {
        if (root == null) return;

        deque.add(root.key);
        m.currSum += root.key;
        if (m.currSum > m.maxSum) {
            m.maxPath = new ArrayList<>(deque);
            m.maxSum = m.currSum;
        }

        findMaxPath(root.left, deque, m);
        findMaxPath(root.right, deque, m);
        deque.removeLast();
        m.currSum -= root.key;
    }

    private static class MyClass {
        int currSum = 0;
        int maxSum = 0;
        List<Integer> maxPath;
    }
}
