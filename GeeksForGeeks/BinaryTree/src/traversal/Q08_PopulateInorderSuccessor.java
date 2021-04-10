package traversal;

/*
Populate Inorder Successor for all nodes
Difficulty Level : Medium

Given a Binary Tree where each node has the following structure, write a function to populate the next pointer for all nodes.
The next pointer for every node should be set to point to inorder successor.*/

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

public class Q08_PopulateInorderSuccessor {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(3);

        List<Node> l = getInorder(tree.root);
        l.forEach(n -> System.out.print(n.key + " "));

        getInorderSuccessorOf(tree.root.right, l);
    }

    private static void getInorderSuccessorOf(Node root, List<Node> l) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == root) {
                if (i == l.size() - 1) {
                    System.out.println();
                    System.out.println("Inorder successor of " + root.key + " is : Not exists");
                } else {
                    System.out.println();
                    System.out.println("Inorder successor of " + root.key + " is :  " + l.get(i + 1).key);
                }
            }
        }
    }

    private static List<Node> getInorder(Node root) {
        List<Node> l = new ArrayList<>();
        getInorder(root, l);
        return l;
    }

    private static void getInorder(Node root, List<Node> l) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            getInorder(root.left, l);
        }
        l.add(root);
        if (root.right != null) {
            getInorder(root.right, l);
        }
    }
}
