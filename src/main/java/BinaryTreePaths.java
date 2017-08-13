import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(result, "", root);
        return result;
    }

    private void dfs(List<String> result, String s, TreeNode n) {
        if (n == null)
            return;
        if (n.left == null && n.right == null) {
            s += n.val;
            result.add(s);
            return;
        }

        dfs(result, s + n.val + "->", n.left);
        dfs(result, s + n.val + "->", n.right);
    }
}
