package main;

import main.utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 8/7/16.
 */
public class SearchRangeinBinarySearchTree {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        helper(root, k1, k2, result);
        return result;
    }

    private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> result)
    {
        if (root == null)
        {
            return;
        }

        if (root.val > k1)
        {
            helper(root.left, k1, k2, result);
        }

        if (root.val <= k2 && root.val >= k1)
        {
            result.add(root.val);
        }

        if (root.val < k2)
        {
            helper(root.right, k1, k2, result);
        }
    }

}

