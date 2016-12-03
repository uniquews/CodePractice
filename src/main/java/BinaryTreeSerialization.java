import utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 8/15/16.
 */
public class BinaryTreeSerialization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        int end = queue.size() - 1;
        while (queue.get(end) == null) {
            queue.remove(end);
            end--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }

        sb.append("}");

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == "{}") {
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < vals.length; i++) {
            TreeNode current = queue.get(index);
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node);
                if (isLeft) {
                    current.left = node;
                } else {
                    current.right = node;
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
