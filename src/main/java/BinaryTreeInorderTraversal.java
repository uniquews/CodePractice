import utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shuaiwang on 8/2/16.
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        // naive way
//        ArrayList<Integer> result = new ArrayList<>();
//
//        if (root == null)
//        {
//            return result;
//        }
//
//        result.addAll(inorderTraversal(root.left));
//        result.add(root.val);
//        result.addAll(inorderTraversal(root.right));
//        return result;

        // use stack
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        TreeNode current = root;
        while (!stk.isEmpty() || current != null) {
            if (current != null) {
                stk.push(current);
                current = current.left;
            } else {
                current = stk.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }
}
