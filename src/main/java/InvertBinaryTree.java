import utils.TreeNode;

/**
 * Created by shuaiwang on 6/2/17.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        TreeNode tmp = leftNode;
        root.left = rightNode;
        root.right = tmp;
        return root;
    }
}
