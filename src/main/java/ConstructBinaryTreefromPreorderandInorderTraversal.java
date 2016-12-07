import utils.TreeNode;

/**
 * Created by shuaiwang on 8/4/16.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here

        if (preorder.length != inorder.length) {
            return null;
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int position = findPosition(root, inorder);

        int leftLength = position - inStart;

        TreeNode leftNode = helper(preorder, preStart + 1, preStart + leftLength, inorder, inStart, inStart + leftLength - 1);
        TreeNode rightNode = helper(preorder, preStart + leftLength + 1, preEnd, inorder, inStart + leftLength + 1, inEnd);

        root.left = leftNode;
        root.right = rightNode;

        return root;

    }

    private int findPosition(TreeNode root, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                return i;
            }
        }

        return -1;
    }
}
