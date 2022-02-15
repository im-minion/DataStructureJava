package gfg.convert;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class YT_11_b_BinaryTreeLeavesToDLL {

    static Node tail = null;
    Node head;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        YT_11_b_BinaryTreeLeavesToDLL obj = new YT_11_b_BinaryTreeLeavesToDLL();
        Node dllLeavesHead = obj.leavesToDLL(tree.root);
        obj.printList(dllLeavesHead);
    }

    private Node leavesToDLL(Node root) {
        if (root == null) return root;

        if (root.left == null && root.right == null) {
            // add to DLL
            if (head == null)
                head = root;
            else {
                root.left = tail;
                tail.right = root;
            }
            tail = root;
            return null;
        }else {
            root.left = leavesToDLL(root.left);
            root.right = leavesToDLL(root.right);
        }
        return head;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.key + " ");
            node = node.right;
        }
    }
}
