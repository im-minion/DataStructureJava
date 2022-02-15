package gfg.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    BinaryTree(int data) {
        this.root = new Node(data);
    }

    public BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(5);

        /*Node Insertion*/
        Node op = insertAtFirstAvailablePosition(binaryTree.root, 6);
        op = insertAtFirstAvailablePosition(op, 7);
        op = insertAtFirstAvailablePosition(op, 8);
        op = insertAtFirstAvailablePosition(op, 9);
        op = insertAtFirstAvailablePosition(op, 10);
        op = insertAtFirstAvailablePosition(op, 3);

        /*BFS Traversal*/
        System.out.println("BFS Traversal");
        printBFS(op);

        /*DFS Traversals*/
        System.out.println("\nDFS InOrder :: ");
        printInorderTraversal(op);

        System.out.println("\nDFS PreOrder :: ");
        printPreOrderTraversal(op);

        System.out.println("\nDFS PostOrder :: ");
        printPostOrderTraversal(op);

        /*Node Deletion*/
        int dataToDelete = 6;
        deleteAndReplaceWithBottomMost(op, dataToDelete);
        System.out.println("\nInOrder After Deleting => " + dataToDelete + " :: ");
        printInorderTraversal(op);
    }

    public static void printBFS(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

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

    private static void deleteAndReplaceWithBottomMost(Node root, int key) {
        if (root == null)
            return;

        if (root.left == null &&
                root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            } else
                return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null; // lastNode
        Node nodeToBeDeleted = null; // nodeToBeDeleted

        // Do level order traversal until we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.key == key)
                nodeToBeDeleted = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (nodeToBeDeleted != null) {
            int lastNodeKey = temp.key;
            deleteDeepest(root, temp);
            nodeToBeDeleted.key = lastNodeKey;
        }
    }

    private static void deleteDeepest(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp == delNode) {
                temp = null;
                return;

            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else
                    q.add(temp.left);
            }
        }

    }

    private static void printPostOrderTraversal(Node root) {
        if (root.left != null) {
            printPostOrderTraversal(root.left);
        }
        if (root.right != null) {
            printPostOrderTraversal(root.right);
        }
        System.out.print(root.key + " ");
    }

    private static void printPreOrderTraversal(Node root) {
        System.out.print(root.key + " ");
        if (root.left != null) {
            printPreOrderTraversal(root.left);
        }
        if (root.right != null) {
            printPreOrderTraversal(root.right);
        }
    }

    public static void printInorderTraversal(Node root) {
        if (root.left != null) {
            printInorderTraversal(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null) {
            printInorderTraversal(root.right);
        }
    }

    public static void printCharInorderTraversal(Node root) {
        if (root.left != null) {
            printCharInorderTraversal(root.left);
        }
        System.out.print((char)root.key + " ");
        if (root.right != null) {
            printCharInorderTraversal(root.right);
        }
    }

    public static Node insertAtFirstAvailablePosition(Node root, int data) {
        Node nodeToInsert = new Node(data);
        if (root == null) {
            return nodeToInsert;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = nodeToInsert;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = nodeToInsert;
                break;
            } else {
                q.add(temp.right);
            }
        }
        return root;
    }
}
