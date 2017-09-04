import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shuaiwang on 3/14/17.
 */
public class SerializeAandDeserializeBinaryTree {
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null)
//            return "";
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        StringBuilder sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            if (cur == null) {
//                sb.append("null ");
//            } else {
//                sb.append(cur.val).append(" ");
//                queue.offer(cur.left);
//                queue.offer(cur.right);
//            }
//        }
//
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.equals("")) {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        String[] nodes = data.split(" ");
//        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
//        queue.offer(root);
//
//        for (int i = 1; i < nodes.length; i++) {
//            TreeNode cur = queue.poll();
//            if (!nodes[i].equals("null")) {
//                TreeNode leftNode = new TreeNode(Integer.valueOf(nodes[i]));
//                queue.offer(leftNode);
//                cur.left = leftNode;
//            }
//            if (!nodes[++i].equals("null")) {
//                TreeNode rightNode = new TreeNode(Integer.valueOf(nodes[i]));
//                queue.offer(rightNode);
//                cur.right = rightNode;
//            }
//        }
//        return root;
//    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                sb.append("null").append(" ");
            } else {
                sb.append(current.val).append(" ");
                q.add(current.left);
                q.add(current.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] s = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        q.add(root);
        for (int i = 1; i < s.length; i++) {
            TreeNode current = q.poll();
            if (!s[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(s[i]));
                current.left = leftNode;
                q.add(leftNode);
            }

            if (!s[++i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(s[i]));
                current.right = rightNode;
                q.add(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        c.left = d;
//        c.right = e;
//
//        a.left = b;
//        a.right = c;
//
//        SerializeAandDeserializeBinaryTree test = new SerializeAandDeserializeBinaryTree();
//        TreeNode result = test.deserialize(test.serialize(a));
//        System.out.println();

        String a = "  b";
        String[] s = a.split(" ");
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
