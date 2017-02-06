import utils.TreeNode;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // write your code here
        flattenSubTree(root);
        return;
    }

    private TreeNode flattenSubTree(TreeNode n) {
        if (n == null || (n.left == null && n.right == null)) {
            return n;
        }

        TreeNode rightNode = n.right;
        n.right = flattenSubTree(n.left);
        n.left = null;
        TreeNode tmp = n;
        while (tmp.right != null) {
            tmp = tmp.right;
        }

        tmp.right = flattenSubTree(rightNode);
        return n;
    }
}
