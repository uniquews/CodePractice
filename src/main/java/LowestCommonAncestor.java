import utils.TreeNode;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, A, B);
        TreeNode rightLCA = lowestCommonAncestor(root.right, A, B);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA;
        }

        if (rightLCA != null) {
            return rightLCA;
        }

        return null;
    }


}
