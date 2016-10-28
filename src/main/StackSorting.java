package main;

import java.util.Stack;

/**
 * Created by shuaiwang on 10/27/16.
 * Hanoi
 *
 * stack = {4,2,1,3}   helper = {}
 * stack = {4,2}      helper = {3,1}
 * stack = {4,1,2}    helper = {3}
 * stack = {4}        helper = {3,2,1}
 * stack = {1,2,3,4}  helper = {}
 * stack = {}         helper = {4,3,2,1}
 * stack = {1,2,3,4}  helper = {}
 *
 */
public class StackSorting {
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()) {
            while (helper.isEmpty() || (!stack.isEmpty() && helper.peek() >= stack.peek())) {
                helper.add(stack.pop());
            }

            if (!stack.isEmpty()) { // stack = {}; helper = {4,3,2,1}
                int value = stack.pop();
                while (!helper.isEmpty() && helper.peek() < value) {
                    stack.add(helper.pop());
                }
                stack.add(value);
            }
        }

        while (!helper.isEmpty()) {
            stack.add(helper.pop());
        }
    }


    public static void main(String[] args) {
        StackSorting test = new StackSorting();
        Stack stk = new Stack();
        stk.add(4);
        stk.add(2);
        stk.add(1);
        stk.add(3);
        test.stackSorting(stk);
    }
}
