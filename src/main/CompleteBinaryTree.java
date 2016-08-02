package main;

import main.utils.TreeNode;

/**
 * Created by shuaiwang on 8/1/16.
 */
public class CompleteBinaryTree {

    private class ResultType
    {
        int depth;
        boolean isFull;
        boolean isComplete;

        ResultType(int depth, boolean isFull, boolean isComplete)
        {
            this.depth = depth;
            this.isFull = isFull;
            this.isComplete = isComplete;
        }
    }
    public boolean isComplete(TreeNode root) {
        // Write your code here
        if (root == null)
        {
            return true;
        }

        return helper(root).isComplete;
    }

    private ResultType helper(TreeNode n)
    {
        if (n == null)
        {
            return new ResultType(1, true, true);
        }

        ResultType leftTree = helper(n.left);
        ResultType rightTree = helper(n.right);

        // check if the current tree is full
        ResultType current = new ResultType(-1, false, false);
        if (leftTree.depth == rightTree.depth)
        {
            current.depth = leftTree.depth + 1;
            if (leftTree.isFull && rightTree.isFull)
            {
                current.isFull = true;
            }
        }
        else if (leftTree != rightTree)
        {
            current.depth = Math.max(leftTree.depth, rightTree.depth) + 1;
        }


        // check if the current tree is complete
        if (leftTree.depth == rightTree.depth)
        {
            if (leftTree.isFull & rightTree.isComplete)
            {
                current.isComplete = true;
            }
        }
        else if (leftTree.depth == rightTree.depth + 1)
        {
            if (leftTree.isComplete && rightTree.isFull)
            {
                current.isComplete = true;
            }
        }
        else
        {
            current.isComplete = false;
        }

        return current;
    }
}
