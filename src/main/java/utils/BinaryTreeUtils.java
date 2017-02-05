package utils;

import java.util.ArrayList;
import java.util.LinkedList;
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
  private static List<String> serializeBinaryTree(TreeNode root) {
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

  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
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
