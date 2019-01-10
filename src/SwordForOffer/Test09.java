package SwordForOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by apple on 1/9/19.
 * Use two stack to implement the queue
 */
public class Test09 {
    public static class MyQueue<T> {
        // input stack, only use to input data
        private Stack<T> stack1 = new Stack();
        // output stack, only use to outupt data
        private Stack<T> stack2 = new Stack();

        public MyQueue() {

        }

        // appendTail: add data at end of queue
        public void appendTail(T t) {
            stack1.add(t);
        }

        // deleteHead: delete data at start of queue
        public T deleteHead() {

            // if output stack is null, add all elements of input stack to the output stack
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element.");
            }

            return stack2.pop();
        }


    }

    public static class MyStack<T> {

        private Queue<T> q1 = new LinkedList<>();

        private Queue<T> q2 = new LinkedList<>();

        static int cur_size;


        public MyStack() {
            this.cur_size = 0;
        }

        //
        public void push(T t) {
            cur_size++;

            // q2 is empty
            q2.add(t);

            // push all remaining elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }

            //swap the name of two queues
            Queue<T> q = q1;
            q1 = q2;
            q2 = q;
        }

        // deleteHead: delete data at start of queue
        public T pop() {

            if (q1.isEmpty()) {
                return null;
            }
            cur_size--;
            return q1.poll();
        }
    }

    public static void main(String[] args){
//        MyQueue<Integer> myQueue = new MyQueue<>();
//        //System.out.println(myQueue.deleteHead());
//        myQueue.appendTail(1);
//        myQueue.appendTail(2);
//        myQueue.appendTail(3);
//        System.out.println(myQueue.deleteHead());
//        System.out.println(myQueue.deleteHead());
//        myQueue.appendTail(4);
//        System.out.println(myQueue.deleteHead());
//        System.out.println(myQueue.deleteHead());
//        System.out.println(myQueue.deleteHead());

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
