package main;

import apple.laf.JRSUIUtils;
import main.utils.TreeNode;

/**
 * Created by shuaiwang on 11/16/16.
 */
public class LowestCommonAncestorIII {

    public boolean foundLeft;
    public boolean foundRight;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode result = helper(root, A, B);

        return foundLeft && foundRight ? result : null;
    }

    private TreeNode helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        TreeNode leftResult = helper(root.left, A, B);
        TreeNode rightResult = helper(root.right, A, B);

        if (root == A && root == B) {
            foundLeft = true;
            foundRight = true;
            return A;
        }

        if (root == A) {
            foundLeft = true;
            return A;
        }

        if (root == B) {
            foundRight = true;
            return B;
        }


        if (leftResult == null || rightResult == null) {
            return leftResult == null ? rightResult : leftResult;
        }

        return root;
    }
}
