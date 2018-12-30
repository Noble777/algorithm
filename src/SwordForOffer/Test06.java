package SwordForOffer;

import java.util.Stack;

/**
 * Created by apple on 12/28/18.
 */
public class Test06 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void reversePrintbyIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }

        ListNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.println(temp.val + " ");
        }
    }

    public static void reversePrintbyRecursion(ListNode root) {
        if (root != null) {
            reversePrintbyRecursion(root.next);
            System.out.println(root.val + " ");
        }
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);

        root.next = new ListNode(2);

        root.next.next = new ListNode(3);

        root.next.next.next = new ListNode(4);

        root.next.next.next.next = new ListNode(5);


        reversePrintbyRecursion(root);
        System.out.println("-------");
        reversePrintbyIteration(root);

    }
}
