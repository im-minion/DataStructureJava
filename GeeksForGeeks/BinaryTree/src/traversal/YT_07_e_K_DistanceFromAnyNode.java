package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.*;

// One Test case Fail :(
public class YT_07_e_K_DistanceFromAnyNode {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node t = tree.root.left.left;

        List<Integer> op = getKthNodes(tree.root, 2, 1);
        System.out.println(op);
    }

    private static List<Integer> getKthNodes(Node root, int key, int k) {
        // hashmap -> nodeToItsParent
        List<Integer> op = new ArrayList<>();

        Node t = getNodeFromTree(key, root);

        if (t == null || root == null) return op;

        if (k == 0) {
            op.add(t.key);
            return op;
        }

        HashMap<Node, Node> hashMap = new HashMap<>();
        hashMap.put(root, null);
        buildMap(root, hashMap);

        List<Node> visited = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(t);
        queue.add(null);

        visited.add(t);

        Node l;
        Node r;
        Node p;

        while (!queue.isEmpty()) {
            Node x = queue.poll();

            if (x == null) {
                if (queue.size() == 0) {
                    return op;
                }
                queue.add(null);
                k--;
                if (k == 0) {
                    x = queue.poll();
                    while (x != null && queue.size() > 0) {
                        op.add(x.key);
                        x = queue.poll();
                    }
                    return op;
                }
            } else {
                l = x.left;
                r = x.right;
                p = hashMap.get(x);

                if (l != null && !visited.contains(l)) {
                    visited.add(l);
                    queue.add(l);
                }

                if (r != null && !visited.contains(r)) {
                    visited.add(r);
                    queue.add(r);
                }

                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    queue.add(p);
                }
            }
        }
        return op;
    }

    private static Node getNodeFromTree(int key, Node root) {
        if (root != null) {
            if (root.key == key) {
                return root;
            }
            if (root.left != null) return getNodeFromTree(key, root.left);
            if (root.right != null) return getNodeFromTree(key, root.right);
        }
        return null;
    }

    private static void buildMap(Node n, HashMap<Node, Node> hashMap) {
        if (n == null) return;
        if (n.left != null) {
            hashMap.put(n.left, n);
        }
        if (n.right != null) {
            hashMap.put(n.right, n);
        }
        buildMap(n.left, hashMap);
        buildMap(n.right, hashMap);
    }
}
