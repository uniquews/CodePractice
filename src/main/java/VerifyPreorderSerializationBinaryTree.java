import java.util.Stack;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<>();
        String[] s = preorder.split(",");

        stk.push(s[0]);
        for (int i = 1; i < s.length; i++) {
            if (!s[i].equals("#")) {
                stk.push(s[i]);
                continue;
            }

            if (stk.peek().equals("#")) {
                while (!stk.isEmpty() && stk.peek().equals("#")) {
                    stk.pop();
                    if (stk.isEmpty()) {
                        return false;
                    } else {
                        stk.pop();
                    }
                }
                stk.push("#");
            } else {
                stk.push(s[i]);
            }
        }
        return stk.size() == 1 && stk.peek().equals("#");
    }
}
