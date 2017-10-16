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

//    public TreeNode str2tree(String s) {
//        if (s == null || s.length() == 0) {
//            return null;
//        }
//
//        int index = 0;
//        while (index < s.length() && (s.charAt(index) != '(' && s.charAt(index) != ')')) {
//            index++;
//        }
//
//        TreeNode cur = new TreeNode(Integer.valueOf(s.substring(0, index)));
//        if (index == s.length()) {
//            return cur;
//        }
//
//        int right = helper(s, index);
//        TreeNode leftNode = str2tree(s.substring(index + 1, right));
//        cur.left = leftNode;
//
//        if (right + 1 < s.length()) {
//            TreeNode rightNode = str2tree(s.substring(right + 2, s.length() - 1));
//            cur.right = rightNode;
//        }
//        return cur;
//    }
//
//    private int helper(String s, int left) {
//        int count = 1;
//        int i = left + 1;
//        for (; i < s.length() && count != 0; i++) {
//            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
//                continue;
//            }
//            if (s.charAt(i) == '(') {
//                count++;
//            }
//            if (s.charAt(i) == ')') {
//                count--;
//            }
//        }
//        return i - 1;
//    }


    private boolean isValidNodeValue(String s, int i) {
        return s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-';
    }
}
