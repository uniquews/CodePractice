import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 5/18/17.
 */
public class SumofLeftLeaves {
//    public int sum = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//        traverse(root.left, true);
//        traverse(root.right, false);
//        return sum;
//    }
//
//    private void traverse(TreeNode n, boolean isLeft) {
//        if (n == null)
//            return;
//
//        if (n.left == null && n.right == null && isLeft) {
//            sum += n.val;
//            return;
//        }
//
//        traverse(n.left, true);
//        traverse(n.right, false);
//    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int ans = 0;
//        if (root.left != null) {
//            if (root.left.left == null && root.left.right == null) {
//                ans += root.left.val;
//            }
//            ans += sumOfLeftLeaves(root.left);
//        }
//        ans += sumOfLeftLeaves(root.right);
//        return ans;
//    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        int ans = 0;
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    ans += cur.left.val;
                } else {
                    stk.push(cur.left);
                }
            }

            if (cur.right != null) {
                stk.push(cur.right);
            }
        }
        return ans;
    }
}
