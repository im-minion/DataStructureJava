import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCompleteness {
    public static void main(String[] args) {
        



        


    }

     public static boolean isCompleteTree(BTNode root) {
        if(root == null) {
            return true;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean end = false;
        while(!queue.isEmpty()) {
            BTNode node = queue.poll();
            if(node == null) {
                end = true;
            } else {
                if(end) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        return true;
        
    }
}