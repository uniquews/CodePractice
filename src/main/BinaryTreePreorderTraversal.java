package main;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shuaiwang on 7/27/16.
 */
public class BinaryTreePreorderTraversal {
//    public ArrayList<Integer> preorderTraversal(TreeNode root) {
//        // write your code here
//        ArrayList<Integer> result = new ArrayList<>();
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//
//        if (root == null)
//        {
//            return result;
//        }
//        stack.push(root);
//        while (!stack.empty())
//        {
//            TreeNode current = stack.pop();
//            result.add(current.val);
//            if (current.right != null)
//            {
//                stack.push(root.right);
//            }
//
//            if (current.left != null)
//            {
//                stack.push(root.left);
//            }
//        }
//
//        return result;
//    }


    // recursion
//    public ArrayList<Integer> preorderTraversal(TreeNode root) {
//        // write your code here
//        ArrayList<Integer> result = new ArrayList<>();
//
//        if (root == null)
//        {
//            return result;
//        }
//        helper(root, result);
//        return result;
//    }
//
//    private void helper(TreeNode n, ArrayList<Integer> result)
//    {
//        if (n == null)
//        {
//            return;
//        }
//
//        result.add(n.val);
//        helper(n.left, result);
//        helper(n.right, result);
//    }

    //Divide & Conquer
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null)
        {
            return result;
        }

        ArrayList<Integer> leftResult = preorderTraversal(root.left);
        ArrayList<Integer> rightResult = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(leftResult);
        result.addAll(rightResult);
        return result;
    }
}
