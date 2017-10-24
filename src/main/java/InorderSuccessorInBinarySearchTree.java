import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 7/28/16.
 */
public class InorderSuccessorInBinarySearchTree {
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode suc = null;
//        while (root != null) {
//            if (root.val <= p.val) {
//                root = root.right;
//            } else {
//                suc = root;
//                root = root.left;
//            }
//        }
//        return suc;
//
//    }

//    private TreeNode last = null;
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        helper(root, p);
//        return last;
//    }
//
//    private void helper(TreeNode n, TreeNode p) {
//        if (n == null) {
//            return;
//        }
//
//        if (n.val <= p.val) {
//            helper(n.right, p);
//        } else {
//            last = n;
//            helper(n.left, p);
//        }
//    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;

        while (!stk.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stk.pop();
                if (cur.val > p.val) {
                    return cur;
                }
                cur = cur.right;
            } else {
                stk.push(cur);
                cur = cur.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);

        a.left = b;
        InorderSuccessorInBinarySearchTree test = new InorderSuccessorInBinarySearchTree();
        test.inorderSuccessor(a, b);
    }
}

