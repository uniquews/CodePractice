package main;

import main.utils.TreeNode;

/**
 * Created by shuaiwang on 8/1/16.
 */
public class IdenticalBinaryTree {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null &&  b == null)
        {
            return true;
        }

        if (a == null || b == null)
        {
            return false;
        }

        if (a.val != b.val)
        {
            return false;
        }

        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
