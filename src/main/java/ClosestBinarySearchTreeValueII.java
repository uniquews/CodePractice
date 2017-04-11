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
        BSTIterator iter = new BSTIterator(root);
        LinkedList<Integer> queue = new LinkedList<>();
        while (iter.hasNext()) {
            int current = iter.next();
            if (queue.isEmpty() || queue.size() < k || (queue.size() == k &&
                    Math.abs(queue.peek() - target) > Math.abs(current - target))) {
                if (queue.size() == k) {
                    queue.poll();
                }
                queue.add(current);
            }
        }
        return queue;
    }
}
