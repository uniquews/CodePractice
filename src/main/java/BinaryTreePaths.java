import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, result, "");
        return result;
    }

    private void dfs(TreeNode n, List<String> result, String s) {
        if (n == null)
            return;
        if (n.left == null && n.right == null) {
            s = s + String.valueOf(n.val);
            result.add(s);
            return;
        }
        dfs(n.left, result, s + n.val + "->");
        dfs(n.right, result, s + n.val + "->");
    }
}
