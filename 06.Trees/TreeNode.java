import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Comparable<TreeNode> {
    int data;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(int data) {
        this.data = data;
    }

    public int compareTo(TreeNode to) {

        return this.data - to.data;
    }
}