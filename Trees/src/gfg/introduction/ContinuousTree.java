package gfg.introduction;

public class ContinuousTree {
    static Node newNode(int data) {
        Node node = new Node(data);
        node.left = node.right = null;
        return (node);
    }

    public static void main(String[] args) {
        Node root = newNode(7);
        root.left = newNode(5);
        root.right = newNode(8);
        root.left.left = newNode(6);
        root.left.right = newNode(4);
        root.right.right = newNode(10);

        BinaryTree.printBFS(root);

        if (treeContinuous(root))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean treeContinuous(Node root) {
        if (root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (Math.abs(root.key - root.left.key) == 1 && Math.abs(root.key - root.right.key) == 1) {
                return treeContinuous(root.left) && treeContinuous(root.right);
            } else {
                return false;
            }
        }
        if(root.left == null) {
            if (Math.abs(root.key - root.right.key) == 1) {
                return treeContinuous(root.right);
            }else {
                return false;
            }
        }

        if(root.right == null) {
            if (Math.abs(root.key - root.left.key) == 1) {
                return treeContinuous(root.left);
            }else {
                return false;
            }
        }
        return false;
    }
}
