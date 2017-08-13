import utils.TreeNode;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class DiameterOfBinaryTree {
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int leftNode = helper(root.left);
        int rightNode = helper(root.right);

        int current = Math.max(leftNode, rightNode) + 1;
        result = Math.max(result, leftNode + rightNode);
        return current;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        DiameterOfBinaryTree test = new DiameterOfBinaryTree();
        test.diameterOfBinaryTree(a);
    }
}
