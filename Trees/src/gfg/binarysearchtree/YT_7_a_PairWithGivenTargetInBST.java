package gfg.binarysearchtree;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.Stack;

// VERIFIED
public class YT_7_a_PairWithGivenTargetInBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(100);

        binaryTree.root.left = new Node(80);
        binaryTree.root.left.left = new Node(60);
        binaryTree.root.left.right = new Node(90);

        binaryTree.root.right = new Node(120);
        binaryTree.root.right.left = new Node(110);
        binaryTree.root.right.right = new Node(130);

        binaryTree.root.right.left.right = new Node(115);

        BinaryTree.printInorderTraversal(binaryTree.root);

        boolean op = isPair(binaryTree.root, 140);

        System.out.println();

        System.out.println(op);
    }

    private static boolean isPair(Node root, int key) {
        if (root == null) return false;

        Stack<Node> stackLeft = new Stack<>();
        Stack<Node> stackRight = new Stack<>();

        pushElements(root, stackLeft, 1);
        pushElements(root, stackRight, 0);

        while (!stackLeft.isEmpty() && !stackRight.isEmpty() && stackLeft.peek().key < stackRight.peek().key) {
            int x = stackLeft.peek().key;
            int y = stackRight.peek().key;
            if (x + y == key) return true;

            if ((x + y) < key) {
                Node n = stackLeft.pop();
                pushElements(n.right, stackLeft, 1);
            } else {
                Node n = stackRight.pop();
                pushElements(n.left, stackRight, 0);
            }
        }
        return false;
    }

    private static void pushElements(Node root, Stack<Node> s, int dir) {
        if (dir == 1) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
        } else {
            while (root != null) {
                s.push(root);
                root = root.right;
            }
        }
    }
}
