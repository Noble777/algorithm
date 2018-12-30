package SwordForOffer;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by apple on 12/30/18.
 */
public class TraversalOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> preorderIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }


    public static List<Integer> inorderIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    // 左右中
    public static List<Integer> postorderIteratively(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // visited
        HashSet<TreeNode> set = new HashSet<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()) {
            cur = stack.pop();
            if (set.contains(cur)) {
                res.add(cur.val);
            }
            else {
                stack.push(cur);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                set.add(cur);
            }
        }

        return res;
    }

    public static void main(String[] args){
        //            1
        //              \
        //               2
        //              /
        //             3
        //pre->123  in->132   post->321  level->123
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        List<Integer> list_preorderRecursively = preorderRecursively(root);
//        System.out.print("preorderRecursively: "+'\t');
//        System.out.println(list_preorderRecursively.toString());
//
//        List<Integer> list_inorderRecursively = inorderRecursively(root);
//        System.out.print("inorderRecursively: "+'\t');
//        System.out.println(list_inorderRecursively.toString());
//
//        List<Integer> list_postorderRecursively = postorderRecursively(root);
//        System.out.print("postorderRecursively: "+'\t');
//        System.out.println(list_postorderRecursively.toString());
//        System.out.println();


        List<Integer> list_preorderIteratively = preorderIteratively(root);
        System.out.print("preorderIteratively: "+'\t');
        System.out.println(list_preorderIteratively.toString());

        List<Integer> list_inorderIteratively = inorderIteratively(root);
        System.out.print("inorderIteratively: "+'\t');
        System.out.println(list_inorderIteratively.toString());

        List<Integer> list_postorderIteratively = postorderIteratively(root);
        System.out.print("postorderIteratively: "+'\t');
        System.out.println(list_postorderIteratively.toString());
        System.out.println();

//        List<Integer> list_levelorder = levelorder(root);
//        System.out.print("levelorder: "+'\t');
//        System.out.println(list_levelorder.toString());
    }


}
