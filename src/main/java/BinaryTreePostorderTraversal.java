import utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shuaiwang on 8/2/16.
 */
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here

        // naive way
//        ArrayList<Integer> result = new ArrayList<>();
//        if (root == null)
//        {
//            return result;
//        }
//
//        ArrayList<Integer> leftTree = postorderTraversal(root.left);
//        ArrayList<Integer> rightTree = postorderTraversal(root.right);
//
//        result.addAll(leftTree);
//        result.addAll(rightTree);
//        result.add(root.val);
//        return result;

        // use stack
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        if (root == null) {
            return result;
        }

        TreeNode last = root;
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode current = stk.peek();
            if ((current.left == null && current.right == null) || current.left == last || current.right == last) {
                result.add(current.val);
                stk.pop();
                last = current;
            } else {
                if (current.right != null) {
                    stk.push(current.right);
                }

                if (current.left != null) {
                    stk.push(current.left);
                }
            }
        }
        return result;
    }
}
