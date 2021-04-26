package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class YT_06_c_TopView {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        printTopView(tree.root);
    }

    private static void printTopView(Node root) {

        Queue<MyClass> queue = new LinkedList<>();
        MyClass myClass = new MyClass(root, 0);

        TreeMap<Integer, Node> map = new TreeMap<>();

        queue.add(myClass);

        while (!queue.isEmpty()) {
            MyClass t = queue.poll();

            if (map.containsKey(t.hd)) {
                // don't do anything
            } else { // only put first value next time ignore
                map.put(t.hd, t.n);
            }

            if (t.n.left != null) queue.add(new MyClass(t.n.left, t.hd - 1));
            if (t.n.right != null) queue.add(new MyClass(t.n.right, t.hd + 1));
        }

        for (Map.Entry<Integer, Node> m : map.entrySet()) {
            System.out.print(m.getValue().key + " ");
        }
    }

    static class MyClass {
        Node n;
        int hd = 0;

        public MyClass(Node root, int i) {
            this.n = root;
            this.hd = i;
        }
    }
}

