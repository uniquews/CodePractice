import utils.TreeNode;

/**
 * Created by shuaiwang on 5/5/17.
 */
public class MinimumAbsoluteDifferenceInBST {
//    private TreeNode last = null;
//
//    private int result = Integer.MAX_VALUE;
//    public int getMinimumDifference(TreeNode root) {
//        inOrder(root);
//        return result;
//    }
//
//    private void inOrder(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        inOrder(node.left);
//        if (last == null) {
//            last = node;
//        } else {
//            result = Math.min(result, Math.abs(node.val - last.val));
//            last = node;
//        }
//        inOrder(node.right);
//    }

    private int prev = -1;
    private int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return diff;
    }

    private void traverse(TreeNode n) {
        if (n == null)
            return;
        traverse(n.left);
        if (prev == -1) {
            prev = n.val;
        } else {
            diff = Math.min(diff, Math.abs(prev - n.val));
            prev = n.val;
        }
        traverse(n.right);
    }
}
