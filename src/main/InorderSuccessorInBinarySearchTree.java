package main;

import main.utils.TreeNode;

/**
 * Created by shuaiwang on 7/28/16.
 */
public class InorderSuccessorInBinarySearchTree {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null)
        {
            return null;
        }

        TreeNode result = null;
        while (root != null && root.val != p.val)
        {
            if (root.val > p.val)
            {
                result = root;
                root = root.left;
            }
            else
            {
                root = root.right; // small and not equal
            }
        }

        if (root.right == null)
        {
            return result;
        }

        root = root.right;
        while (root.left != null)
        {
            root = root.left;
        }

        return root;

    }
}
