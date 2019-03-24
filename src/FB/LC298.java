package FB;
/*
    Given a binary tree, find the length of the longest consecutive sequence path.
 */
public class LC298 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static int max = 0;
    public static int longestConsecutive1(TreeNode root) {
        if (root == null) {
            return max;
        }

        helper(root, 0, root.val);
        return max;
    }

    public static void helper(TreeNode root, int cur, int target) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            cur++;
        }
        else {
            cur = 1;
        }
        max = Math.max(max, cur);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(longestConsecutive1(root));
    }
}
