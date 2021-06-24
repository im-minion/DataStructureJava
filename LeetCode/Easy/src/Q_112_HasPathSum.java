public class Q_112_HasPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null && targetSum == 0) return false;
        if (root == null && targetSum != 0) return false;
        MyKlass m = new MyKlass();
        solve(root, m, targetSum);
        // System.out.println(m.currSum);
        return m.op;
    }

    public static void solve(TreeNode root, MyKlass m, int targetSum) {
        if (root == null) return;
        m.currSum += root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == m.currSum) {
                m.op = true;
            }
        }
        solve(root.left, m, targetSum);

        solve(root.right, m, targetSum);

        m.currSum -= root.val;
        ;

    }

    static class MyKlass {
        int currSum = 0;
        boolean op = false;
    }
}
