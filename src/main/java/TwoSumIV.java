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
    boolean direct;
    public BSTIterator(TreeNode root, boolean direct) {
        stk = new Stack<>();
        cur = root;
        this.direct = direct;
    }

    private TreeNode helper() {
        TreeNode result = null;
        while (cur != null) {
            stk.push(cur);
            if (direct) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (!stk.isEmpty()) {
            result = stk.pop();
            if (direct) {
                cur = result.right;
            } else {
                cur = result.left;
            }
        }
        return result;
    }


    public Integer next() {
        Integer result = helper().val;
        return result;
    }

    public boolean hasNext() {
        return !stk.isEmpty() || cur != null;
    }
}

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator iter1 = new BSTIterator(root, true);
        BSTIterator iter2 = new BSTIterator(root, false);

        if (!iter1.hasNext() || !iter2.hasNext()) {
            return false;
        }

        int tmp1 = iter1.next();
        int tmp2 = iter2.next();

        while (tmp1 < tmp2) {
            if (tmp1 + tmp2 == k) {
                return true;
            } else if (tmp1 + tmp2 < k) {
                tmp1 = iter1.next();
            } else {
                tmp2 = iter2.next();
            }
        }
        return false;
    }
}
