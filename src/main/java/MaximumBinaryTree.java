import utils.TreeNode;

import java.util.Stack;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Stack<TreeNode> stk = new Stack<>();
        stk.push(new TreeNode(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            TreeNode newNode = new TreeNode(nums[i]);
            if (nums[i] < stk.peek().val) {
                stk.peek().right = newNode;
                stk.push(newNode);
            } else {
                TreeNode tmp = null;
                while (!stk.isEmpty() && stk.peek().val < nums[i]) {
                    tmp = stk.pop();
                }
                newNode.left = tmp;
                if (!stk.isEmpty()) {
                    stk.peek().right = newNode;
                }
                stk.push(newNode);
            }
        }
        TreeNode result = null;
        while (!stk.isEmpty()) {
            result = stk.pop();
        }
        return result;
    }
}
