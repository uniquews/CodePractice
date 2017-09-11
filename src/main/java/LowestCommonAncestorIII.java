import utils.TreeNode;

/**
 * Created by shuaiwang on 11/16/16.
 */
public class LowestCommonAncestorIII {

    public boolean foundLeft;
    public boolean foundRight;

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode result = helper(root, A, B);

        return foundLeft && foundRight ? result : null;
    }

    private TreeNode helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        // 一定要先扫描完整棵树，否则当A是B的子树时，发现root == B 就直接return, foundLeft不会被设置成true
        TreeNode leftResult = helper(root.left, A, B);
        TreeNode rightResult = helper(root.right, A, B);

        if (root == A && root == B) {
            foundLeft = true;
            foundRight = true;
            return A;
        }

        if (root == A) {
            foundLeft = true;
            return A;
        }

        if (root == B) {
            foundRight = true;
            return B;
        }


        if (leftResult == null || rightResult == null) {
            return leftResult == null ? rightResult : leftResult;
        }

        return root;
    }





//    class ReturnType {
//        public TreeNode lca;
//        public boolean foundA;
//        public boolean foundB;
//
//        public ReturnType(TreeNode n, boolean a, boolean b) {
//            lca = n;
//            foundA = a;
//            foundB = b;
//        }
//    }
//
//    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
//        // write your code here
//        return helper(root, A, B).lca;
//    }
//
//    private ReturnType helper(TreeNode n, TreeNode A, TreeNode B) {
//        if (n == null) {
//            return new ReturnType(null, false, false);
//        }
//
//        ReturnType result = new ReturnType(null, false, false);
//        if (n.val == A.val) {
//            result.foundA = true;
//        }
//
//        if (n.val == B.val)  {
//            result.foundB = true;
//        }
//
//        ReturnType leftNode = helper(n.left, A, B);
//        ReturnType rightNode = helper(n.right, A, B);
//
//        if (leftNode.lca != null) {
//            return leftNode;
//        }
//
//        if (rightNode.lca != null) {
//            return rightNode;
//        }
//
//        result.foundA = result.foundA || leftNode.foundA || rightNode.foundA;
//        result.foundB = result.foundB || leftNode.foundB || rightNode.foundB;
//        if (result.foundA && result.foundB) {
//            result.lca = n;
//        }
//        return result;
//    }
}
