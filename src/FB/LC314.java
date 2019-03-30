package FB;

import java.util.*;

public class LC314 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // check edge case
        if (root == null) {
            return res;
        }

        // map to keep col-Array pair, represent the element in this array has the same col
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        queue.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();

            // put into the map
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }

            map.get(col).add(node.val);

            // left
            if (node.left != null) {
                queue.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            // right
            if (node.right != null) {
                queue.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        // out the res in the map base on the col
        for (int i = min; i < max + 1; i++) {
            res.add(map.get(i));
        }

        return res;
    }
}
