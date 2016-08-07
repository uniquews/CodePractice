package main;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by shuaiwang on 8/7/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
//    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
//        // write your code here
//
//        // Way 1: Save space but level.add(0, current.val); is time consuming
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//
//        if (root == null)
//        {
//            return result;
//        }
//
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        boolean leftToRight = true;
//
//        while (!queue.isEmpty())
//        {
//            ArrayList<Integer> level = new ArrayList<>();
//            int queueSize = queue.size();
//            for (int i = 0; i < queueSize; i++)
//            {
//
//                TreeNode current;
//                current = queue.poll();
//                if (leftToRight)
//                {
//                    level.add(current.val);
//                }
//                else
//                {
//                    level.add(0, current.val);
//                }
//
//                if (current.left != null)
//                {
//                    queue.offer(current.left);
//                }
//
//                if (current.right != null)
//                {
//                    queue.offer(current.right);
//                }
//            }
//
//            leftToRight = !leftToRight;
//            result.add(level);
//        }
//        return result;
//    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here

        // Way 2: Save time but use two stacks
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null)
        {
            return result;
        }
        boolean leftToRight = true;

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        currentLevel.push(root);
        while (!currentLevel.isEmpty())
        {
            ArrayList<Integer> level = new ArrayList<>();
            while (!currentLevel.isEmpty())
            {
                TreeNode current = currentLevel.pop();
                level.add(current.val);

                if (leftToRight)
                {
                    if (current.left != null)
                    {
                        nextLevel.push(current.left);
                    }

                    if (current.right != null)
                    {
                        nextLevel.push(current.right);
                    }
                }
                else
                {
                    if (current.right != null)
                    {
                        nextLevel.push(current.right);
                    }

                    if (current.left != null)
                    {
                        nextLevel.push(current.left);
                    }
                }
            }
            result.add(level);
            currentLevel.addAll(nextLevel);
            nextLevel.clear();
            leftToRight  = !leftToRight;
        }
        return result;
    }
}
