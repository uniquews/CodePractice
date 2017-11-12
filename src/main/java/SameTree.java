import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 6/3/17.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Stack<TreeNode> stk1 = new Stack<>();
//        Stack<TreeNode> stk2 = new Stack<>();
//
//        if (p != null) {
//            stk1.push(p);
//        }
//
//        if (q != null) {
//            stk2.push(q);
//        }
//
//        while (!stk1.isEmpty() && !stk2.isEmpty()) {
//            TreeNode a = stk1.pop();
//            TreeNode b = stk2.pop();
//            if (a.val != b.val) {
//                return false;
//            }
//            if (a.left != null) {
//                stk1.push(a.left);
//            }
//
//            if (b.left != null) {
//                stk2.push(b.left);
//            }
//
//            if (stk1.size() != stk2.size()) {
//                return false;
//            }
//
//            if (a.right != null) {
//                stk1.push(a.right);
//            }
//
//            if (b.right != null) {
//                stk2.push(b.right);
//            }
//
//            if (stk1.size() != stk2.size()) {
//                return false;
//            }
//        }
//        return stk1.isEmpty() && stk2.isEmpty();
//    }
}
