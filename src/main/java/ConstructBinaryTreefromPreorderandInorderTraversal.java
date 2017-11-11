import utils.TreeNode;

/**
 * Created by shuaiwang on 8/4/16.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0)
//            return null;
//        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//    }
//
//    private TreeNode helper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
//        if (s1 == e1) {
//            return new TreeNode(preorder[s1]);
//        }
//
//        TreeNode node = new TreeNode(preorder[s1]);
//        int index = 0;
//        for (int i = s2; i <= e2; i++) {
//            if (preorder[s1] == inorder[i]) {
//                index = i;
//            }
//        }
//
//        int leftLength = index - s2;
//        int rightLength = e2 - s2 - leftLength;
//
//        TreeNode leftNode = null;
//        TreeNode rightNode = null;
//
//        if (leftLength != 0) {
//            leftNode = helper(preorder, s1 + 1, s1 + 1 + leftLength - 1, inorder, s2, s2 + leftLength - 1);
//        }
//
//        if (rightLength != 0) {
//            rightNode = helper(preorder, s1 + leftLength + 1, e1, inorder, index + 1, e2);
//        }
//
//        node.left = leftNode;
//        node.right = rightNode;
//        return node;
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }

        if (s1 == e1) {
            return new TreeNode(preorder[s1]);
        }

        TreeNode root = new TreeNode(preorder[s1]);
        int rootInorder = -1;

        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                rootInorder = i;
            }
        }

        int leftLen = rootInorder - s2;
        TreeNode leftNode = helper(preorder, s1 + 1, s1 + leftLen, inorder, s2, rootInorder - 1);
        TreeNode rightNode = helper(preorder, s1 + leftLen + 1, e1, inorder, rootInorder + 1, e2);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};

        ConstructBinaryTreefromPreorderandInorderTraversal test = new ConstructBinaryTreefromPreorderandInorderTraversal();
        test.buildTree(preorder, inorder);
    }
}
