package main;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 10/25/16.
 */
public class ImplementStack {
    private ArrayList<Integer> array = new ArrayList<>();
    private int size = 0;

    public void push(int x) {
        // Write your code here
        array.add(x);
        size++;
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        array.remove(size - 1);
        size--;
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return array.get(size - 1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return array.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStack test = new ImplementStack();
        test.push(1);
        test.pop();
        test.push(2);
        test.isEmpty();
        test.top();
        test.pop();
        test.isEmpty();
    }
}


