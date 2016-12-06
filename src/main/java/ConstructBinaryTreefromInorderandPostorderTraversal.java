import utils.TreeNode;

/**
 * Created by shuaiwang on 8/4/16.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length) {
            return null;
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int position = findPosition(root, inorder);

        int leftLength = position - inStart;

        TreeNode leftNode = helper(inorder, inStart, position - 1, postorder, postStart, postStart + leftLength - 1);
        TreeNode rightNode = helper(inorder, position + 1, inEnd, postorder, postStart + leftLength, postEnd - 1);
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
