import utils.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        Stack<TreeNode> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }

            if (i < s.length() && isValidNodeValue(s, i)) {
                int end = i + 1;
                while (end < s.length() && isValidNodeValue(s, end)) {
                    end++;
                }

                String val = s.substring(i, end);
                TreeNode n = new TreeNode(Integer.valueOf(val));
                stk.push(n);
                i = end - 1;
            } else { // i is ')'
                TreeNode n = stk.pop();
                TreeNode cur = stk.peek();
                if (cur.left == null) {
                    cur.left = n;
                } else {
                    cur.right = n;
                }
            }
        }

        return stk.peek();
    }

    private boolean isValidNodeValue(String s, int i) {
        return s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-';
    }
}
