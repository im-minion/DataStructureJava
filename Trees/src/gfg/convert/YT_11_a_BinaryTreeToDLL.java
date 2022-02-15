package gfg.convert;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

// Verified:: TODO: Little difficult;
public class YT_11_a_BinaryTreeToDLL {


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
        YT_11_a_BinaryTreeToDLL obj = new YT_11_a_BinaryTreeToDLL();
        Node dllHead = obj.bToDLL(tree.root);
        obj.printList(dllHead);
    }

    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
        //  Your code here
        BtoLL(root);
        return head;
    }

    void BtoLL(Node root) {
        if (root == null) return;

        BtoLL(root.left);

        if (head == null) head = root;
        else {
            root.left = tail;
            tail.right = root;
        }
        tail = root;

        BtoLL(root.right);
    }


    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.key + " ");
            node = node.right;
        }
    }
}
