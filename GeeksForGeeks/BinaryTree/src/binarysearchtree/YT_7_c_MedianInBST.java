package binarysearchtree;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

public class YT_7_c_MedianInBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(6);

        binaryTree.root.left = new Node(3);
        binaryTree.root.left.left = new Node(1);
        binaryTree.root.left.right = new Node(4);

        binaryTree.root.right = new Node(8);
        binaryTree.root.right.left = new Node(7);
        binaryTree.root.right.right = new Node(9);

//        binaryTree.root.right.left.right = new Node(115);

        BinaryTree.printInorderTraversal(binaryTree.root);

        int op = getMedian(binaryTree.root);

        System.out.println();

        System.out.println(op);
    }

    private static int getMedian(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int size = list.size();

        if (size % 2 == 0) {
            // if()
            int mid = size / 2;
            int mid1 = mid - 1;
            return ((list.get(mid) + list.get(mid1)) / 2);
        } else {
            return (list.get(size / 2));
        }
    }

    private static void inorder(Node root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.key);
        inorder(root.right, list);
    }
}

/*
 * size = 7
 * index op=> 3
 *
 * size = 8
 * index op => 3 and 4
 *
 *
 * */
