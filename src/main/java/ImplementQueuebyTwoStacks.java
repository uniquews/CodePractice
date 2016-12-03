import java.util.Stack;

/**
 * Created by shuaiwang on 10/23/16.
 */
public class ImplementQueuebyTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueuebyTwoStacks() {
        // do initialization if necessary
        stack1 = new Stack<>(); // push stack
        stack2 = new Stack<>(); // pop stack
    }

    public void push(int element) {
        // write your code here
        while (!stack2.isEmpty()) {
            int cur = stack2.pop();
            stack1.push(cur);
        }
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while (!stack1.isEmpty()) {
            int cur = stack1.pop();
            stack2.push(cur);
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        while (!stack1.isEmpty()) {
            int cur = stack1.pop();
            stack2.push(cur);
        }
        return stack2.peek();
    }
}
