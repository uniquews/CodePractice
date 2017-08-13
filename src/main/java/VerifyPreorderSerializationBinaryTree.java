import java.util.Stack;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<>();
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].equals("#")) {
                stk.push(strs[i]);
            } else {
                while (!stk.isEmpty() && stk.peek().equals("#")) {
                    stk.pop();
                    if (!stk.isEmpty() && !stk.peek().equals("#")) {
                        stk.pop();
                    } else {
                        return false;
                    }
                }

                stk.push("#");
            }
        }
        return stk.size() == 1 && stk.peek().equals("#");
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        VerifyPreorderSerializationBinaryTree test = new VerifyPreorderSerializationBinaryTree();
        test.isValidSerialization(s);
    }


}
