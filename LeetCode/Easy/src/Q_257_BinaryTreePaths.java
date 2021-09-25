import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_257_BinaryTreePaths {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> op = new ArrayList<>();
        solve(root, op, new StringBuilder());
        return op;
    }

    public void solve(TreeNode root, List<String> op, StringBuilder path) {
        if (root == null) return;
        path.append(root.val);
        if (root.left == null && root.right == null) {
            //add to curr and return
            op.add(path.toString());
            return;
        } else {
            path.append("->");
            solve(root.left, op, new StringBuilder(path));
            solve(root.right, op, new StringBuilder(path));
        }
    }
}