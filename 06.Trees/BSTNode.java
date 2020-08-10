public class BSTNode {
    
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(final int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {

        return " " + this.data;
    }
}