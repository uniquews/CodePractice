import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 10/26/16.
 */
public class ImplementStackbyTwoQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    private void moveElement(Queue<Integer> q1, Queue<Integer> q2) {
        while (q1.size() != 1) {
            int tmp = q1.poll();
            q2.add(tmp);
        }
    }

    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        q1.add(x);
    }

    private void swap() {
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        moveElement(q1, q2);
        q1.poll();
        swap();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        moveElement(q1, q2);
        int result = q1.poll();
        q2.add(result);
        swap();
        return result;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackbyTwoQueues test = new ImplementStackbyTwoQueues();
        test.push(1);
        test.push(2);
        test.pop();
        test.top();
        test.push(3);
    }
}
