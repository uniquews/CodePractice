import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        dfs(root, 0, target, path, result);
        return result;
    }

    private void dfs(TreeNode n, int sum, int target, List<Integer> path, List<List<Integer>> result) {
        if (n == null) {
            return;
        }
        path.add(n.val);

        if (n.left == null && n.right == null) {
            if (target - sum == n.val) {
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }

        dfs(n.left, sum + n.val, target, path, result);
        dfs(n.right, sum + n.val, target, path, result);
        path.remove(path.size() - 1);
    }

}
