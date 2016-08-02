package main;

import main.utils.TreeNode;

/**
 * Created by shuaiwang on 8/1/16.
 */
public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null)
        {
            return true;
        }

        return isIdenticalTree(root.left, root.right);
    }

    private boolean isIdenticalTree(TreeNode a, TreeNode b)
    {
        if (a == null && b == null)
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

        return isIdenticalTree(a.left, b.right) && isIdenticalTree(a.right, a.left);
    }
}
