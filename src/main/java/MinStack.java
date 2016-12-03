import java.util.Stack;

/**
 * Created by shuaiwang on 10/23/16.
 */
public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        // do initialize if necessary
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int number) {
        // write your code here
        stack1.push(number);
        if (stack2.isEmpty() || stack2.peek() >= number) {
            stack2.push(number);
        }
    }

    public int pop() {
        // write your code here
        int cur = stack1.pop();
        if (cur == stack2.peek()) {
            stack2.pop();
        }
        return cur;
    }

    public int min() {
        // write your code here
        return stack2.peek();
    }
}
