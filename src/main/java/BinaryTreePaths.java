import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        String s = "";
        helper(root, s, result);
        return result;
    }

    private void helper(TreeNode n, String s, List<String> result) {
        if (n == null) {
            return;
        }

        if (n.left == null && n.right == null) {
            result.add(s + n.val);
            return;
        }

        helper(n.left, s + n.val + "->", result);
        helper(n.right, s + n.val + "->", result);
    }
}
