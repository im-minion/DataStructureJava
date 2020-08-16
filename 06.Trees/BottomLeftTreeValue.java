import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftTreeValue {

    public static int bottomLeftTreeVal(BTNode root) {
        // use queue and traverse right then left
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }
        return root.data;
    }
    public static void main(String[] args) {
        System.out.println("Creating a tree.");
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        root.left.left.right = new BTNode(8);
        System.out.println("Tree constructed.");

        int val = bottomLeftTreeVal(root);
        System.out.println("Left most node of the tree is " + val);
    }
}