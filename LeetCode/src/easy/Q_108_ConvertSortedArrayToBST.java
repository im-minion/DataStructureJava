public class Q_108_ConvertSortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = (0 + nums.length - 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = convert(root, 0, mid - 1, nums);

        root.right = convert(root, mid + 1, nums.length - 1, nums);

        return root;
    }

    public static TreeNode convert(TreeNode root, int l, int r, int[] nums) {
        while (l <= r) {
            int m = (l + r) / 2;
            TreeNode node = new TreeNode(nums[m]);
            node.left = convert(node, l, m - 1, nums);
            node.right = convert(node, m + 1, r, nums);
            return node;
        }
        return null;
    }
}
