package convert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Verified
public class YT_11_c_ConstructBinaryTreeFromSLL {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Tree n = convert(head, null);

        printBFS(n);
    }

    public static Tree convert(Node head, Tree node) {
        // add code here.}
        List<Tree> treeNodes = new ArrayList<>();
        Node n = head;
        while (n != null) {
            treeNodes.add(new Tree(n.data));
            n = n.next;
        }
        int size = treeNodes.size();
        for (int i = 0; i < size / 2; i++) {
            if (2 * i + 1 < size) {
                treeNodes.get(i).left = treeNodes.get(2 * i + 1);
            }
            if (2 * i + 2 < size) {
                treeNodes.get(i).right = treeNodes.get(2 * i + 2);
            }
        }

        return treeNodes.get(0);


    }

    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void printBFS(Tree root) {
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }

}
