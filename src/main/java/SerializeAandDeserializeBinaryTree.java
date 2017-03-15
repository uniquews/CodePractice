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
    public String serialize(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode current = queue.get(i);
            if (current != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        // The end of string doesn't contain any null node
        int end = queue.size() - 1;
        while (end >= 0 && queue.get(end) == null) {
            queue.remove(end);
            end--;
        }

        if (end < 0) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode current = queue.get(i);
            if (current == null) {
                sb.append(",null");
            } else {
                sb.append(",").append(current.val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("{}"))
            return null;

        String[] dataArray = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[0]));
        queue.add(root);

        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < dataArray.length; i++) {
            TreeNode node = queue.get(index);
            if (!dataArray[i].equals("null")) {
                TreeNode child = new TreeNode(Integer.valueOf(dataArray[i]));
                queue.add(child);
                if (isLeft) {
                    node.left = child;
                } else {
                    node.right = child;
                }
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}
