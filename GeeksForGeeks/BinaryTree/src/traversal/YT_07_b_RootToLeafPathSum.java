package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class YT_07_b_RootToLeafPathSum {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        boolean op = isSumPath(tree.root, 12);

        System.out.println(op);

        boolean op2 = isSumPath2(tree.root, 12);

        System.out.println(op2);
    }


    /****************** Option 1************************/
    private static boolean isSumPath(Node root, int sum) {
        List<Integer> allSums = getAllRootToLeafSums(root);
        System.out.println(allSums);
        return allSums.contains(sum);
    }

    private static List<Integer> getAllRootToLeafSums(Node root) {

        List<Integer> op = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        getSums(root, deque, op, new MyClass());
        return op;
    }

    private static void getSums(Node root, Deque<Node> deque, List<Integer> op, MyClass myClass) {

        if (root == null) return;
        deque.add(root);
        myClass.sum = myClass.sum + root.key;
        if (root.left == null && root.right == null) {
            op.add(myClass.sum);
        }

        getSums(root.left, deque, op, myClass);
        getSums(root.right, deque, op, myClass);

        Node lastAdded = deque.peekLast();
        myClass.sum = myClass.sum - lastAdded.key;
        deque.removeLast();
    }

    static class MyClass {
        int sum = 0;
    }


    /****************** Option 2************************/
    private static boolean isSumPath2(Node root, int sum) {
        MyObj o = new MyObj();
        findSum(root, o, sum);
        return o.isFound;
    }

    private static void findSum(Node root, MyObj o, int sum) {
        if (root == null) return;
        o.sum += root.key;
        if (root.left == null && root.right == null) {
            if (sum == o.sum) {
                o.isFound = true;
            }
        }
        findSum(root.left, o, sum);
        findSum(root.right, o, sum);
        o.sum -= root.key;
    }

    static class MyObj {
        boolean isFound = false;
        int sum = 0;
    }
}
