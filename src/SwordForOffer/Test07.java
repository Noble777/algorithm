package SwordForOffer;

//import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.List;
import SwordForOffer.TraversalOfBinaryTree.TreeNode;
/**
 * Created by apple on 12/30/18.
 */
public class Test07 {

    static HashMap<Integer, TreeNode> map;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart == preorder.length || inStart > inEnd) {
            return null;
        }
        if (map.containsKey(preorder[preStart])) {
            return map.get(preorder[preStart]);
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        while (inorder[inIndex] != root.val) {
            inIndex++;
        }
        root.left = buildTree(preorder, inorder,preStart + 1 , inStart, inIndex - 1);
        root.right = buildTree(preorder, inorder, preStart + inIndex - inStart + 1,inIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre={1,2,4,5,3};
        int[] in={4,2,5,1,3};
        TreeNode root = buildTree(pre,in);

        List<Integer> preorder = TraversalOfBinaryTree.preorderIteratively(root);
        List<Integer> inorder = TraversalOfBinaryTree.inorderIteratively(root);
        List<Integer> postorder = TraversalOfBinaryTree.postorderIteratively(root);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

}
