import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stk.isEmpty() || temperatures[stk.peek()] >= temperatures[i]) {
                stk.push(i);
            } else {
                while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                    int cur = stk.pop();
                    result[cur] = i - cur;
                }
                stk.push(i);
            }
        }
        return result;
    }
}
