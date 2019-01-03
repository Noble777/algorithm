package SwordForOffer;

/**
 * Created by apple on 1/2/19.
 */
public class Test08 {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode father;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.father = null;
        }
    }

    public static TreeNode findNextTreeNode(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        else {
            if (pNode.father == null) {
                return null;
            }
            else {
                while (pNode.father != null) {
                    if (pNode.father.left == pNode) {
                        return pNode.father;
                    }
                    pNode = pNode.father;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.father = root;
        root.right = new TreeNode(3);
        root.right.father = root;
        root.left.left = new TreeNode(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.father = root.left;

        System.out.println(findNextTreeNode(root.left.left).val);
        System.out.println(findNextTreeNode(root.left).val);
        System.out.println(findNextTreeNode(root.left.right).val);
        System.out.println(findNextTreeNode(root).val);
        System.out.println(findNextTreeNode(root.right));
    }


}
