import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by shuaiwang on 8/26/17.
 */
public class TwoSumIV {
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        return dfs(root, set, k);
//    }
//
//    private boolean dfs(TreeNode n, Set<Integer> set, int target) {
//        if (n == null) {
//            return false;
//        }
//
//        if (set.contains(target - n.val)) {
//            return true;
//        }
//
//        set.add(n.val);
//        boolean leftNode = dfs(n.left, set, target);
//        boolean rightNode = dfs(n.right, set, target);
//        return leftNode || rightNode;
//    }
    class BSTIterator {
        Stack<TreeNode> stk;
        TreeNode cur;
        public BSTIterator(TreeNode root) {
            stk = new Stack<>();
            cur = root;
        }

        private TreeNode helper() {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }

            TreeNode result = null;
            if (!stk.isEmpty()) {
                result = stk.pop();
                cur = result.right;
            }
            return result;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stk.isEmpty() || cur != null;
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode result = helper();
            return result.val;
        }
    }

    class BSTIterator2 {
        Stack<TreeNode> stk;
        TreeNode cur;
        public BSTIterator2(TreeNode root) {
            stk = new Stack<>();
            cur = root;
        }

        private TreeNode helper() {
            while (cur != null) {
                stk.push(cur);
                cur = cur.right;
            }

            TreeNode result = null;
            if (!stk.isEmpty()) {
                result = stk.pop();
                cur = result.left;
            }
            return result;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stk.isEmpty() || cur != null;
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode result = helper();
            return result.val;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator iter1 = new BSTIterator(root);
        BSTIterator2 iter2 = new BSTIterator2(root);
        if (!iter1.hasNext() || !iter2.hasNext()) {
            return false;
        }
        int tmp1 = iter1.next();
        int tmp2 = iter2.next();

        while (iter1.hasNext() && iter2.hasNext()) {
            if (tmp1 == tmp2 || tmp1 > tmp2) {
                break;
            }
            if (tmp1 + tmp2 == k) {
                return true;
            }else if (tmp1 + tmp2 < k) {
                tmp1 = iter1.next();
            } else {
                tmp2 = iter2.next();
            }
        }
        return false;
    }
}
