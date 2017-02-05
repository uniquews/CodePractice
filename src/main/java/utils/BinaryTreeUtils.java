package utils;

/**
 * Created by shuaiwang on 2/4/17.
 */

import java.util.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * utility class to simplify test for binary tree
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeUtils {
    public static List<String> serializeBinaryTree(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add("#");
                continue;
            }
            res.add(Integer.toString(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            if (!res.get(i).equals("#")) {
                break;
            }
            res.remove(i);
        }
        return res;
    }

    public static TreeNode constructBinaryTree(List<String> nodes) {
        Queue<String> queue = new LinkedList<>(nodes);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (queue.isEmpty()) {
                break;
            }
            String leftVal = queue.poll();
            if (leftVal != null && !leftVal.equals("#")) {
                node.left = new TreeNode(Integer.valueOf(leftVal));
                nodeQueue.offer(node.left);
            }
            String rightVal = queue.poll();
            if (rightVal != null && !rightVal.equals("#")) {
                node.right = new TreeNode(Integer.valueOf(rightVal));
                nodeQueue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * @param nums 0 means "#"
     * @return
     */
    public static TreeNode constructBinaryTree(int... nums) {
        List<String> nodes = new ArrayList<>(nums.length);
        for (int n : nums) {
            nodes.add(n == 0 ? "#" : Integer.toString(n));
        }
        return constructBinaryTree(nodes);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        StringBuilder sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                sb.append("#");
//            } else {
//                sb.append(node.val);
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }
//            sb.append(",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
        List<String> strs = serializeBinaryTree(root);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strs = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < strs.length && !strs[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < strs.length && !strs[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
