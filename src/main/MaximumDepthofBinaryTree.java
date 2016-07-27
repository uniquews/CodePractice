package main;

import main.utils.TreeNode;

/**
 * Created by shuaiwang on 7/26/16.
 */
public class MaximumDepthofBinaryTree {

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        // write your code here
        int depth = 0;
        helper(root, 1);
        return maxDepth;
    }

    private void helper(TreeNode node, int currentDepth)
    {
        if (node == null)
        {
            return;
        }

        if (currentDepth > maxDepth)
        {
            maxDepth = currentDepth;
        }

        helper(node.left, currentDepth + 1);
        helper(node.right, currentDepth + 1);
    }
}
