package misc;

public class BTNode {
    
    int data;
    BTNode left;
    BTNode right;

    public BTNode(final int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {

        return " " + this.data;
    }
}