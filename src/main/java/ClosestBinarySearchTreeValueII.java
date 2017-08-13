import utils.TreeNode;

import java.util.*;

/**
 * Created by shuaiwang on 4/10/17.
 */
public class ClosestBinarySearchTreeValueII {
    class BSTIterator {
        Stack<TreeNode> stk;
        TreeNode current;
        public BSTIterator(TreeNode root) {
            stk = new Stack<>();
            current = root;
        }

        /** @return whether we have a next smallest number */
        public int next() {
            while (current != null) {
                stk.push(current);
                current = current.left;
            }
            current = stk.pop();
            int result = current.val;
            current = current.right;
            return result;
        }

        public boolean hasNext() {
            return current != null || !stk.isEmpty();
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        BSTIterator it = new BSTIterator(root);
        LinkedList<Integer> q = new LinkedList<>();
        while (it.hasNext()) {
            int current = it.next();
            if (q.isEmpty() || q.size() < k || Math.abs(q.peek() - target) < Math.abs(current - target)) {
                if (q.size() == k)
                    q.poll();
                q.add(current);
            }
        }
        return q;
    }
}
