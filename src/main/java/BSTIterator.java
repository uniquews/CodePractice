import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 8/16/16.
 */
public class BSTIterator {
    Stack<TreeNode> stk;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        cur = root;
    }

    private Integer helper() {
        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }

        cur = stk.pop();
        Integer result = cur.val;
        cur = cur.right;
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return helper();
    }
}

