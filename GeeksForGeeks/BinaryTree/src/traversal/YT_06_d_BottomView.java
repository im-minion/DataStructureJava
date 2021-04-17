package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class YT_06_d_BottomView {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        printBottomView(tree.root);
    }

    private static void printBottomView(Node root) {
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<YT_06_c_TopView.MyClass> queue = new LinkedList<>();

        YT_06_c_TopView.MyClass curr = new YT_06_c_TopView.MyClass(root, 0);

        queue.add(curr);

        while (!queue.isEmpty()) {
            YT_06_c_TopView.MyClass t = queue.poll();
            map.put(t.hd, t.n);
            if (t.n.left != null) queue.add(new YT_06_c_TopView.MyClass(t.n.left, t.hd - 1));
            if (t.n.right != null) queue.add(new YT_06_c_TopView.MyClass(t.n.right, t.hd + 1));
        }

        for (Map.Entry<Integer, Node> m : map.entrySet()) {
            System.out.println(m.getValue().key);
        }

    }
}
