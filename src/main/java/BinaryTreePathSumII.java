import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 5/29/17.
 */
public class BinaryTreePathSumII {
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, target, result, new ArrayList<>());
        result.addAll(binaryTreePathSum2(root.left, target));
        result.addAll(binaryTreePathSum2(root.right, target));
        return result;
    }

    private void helper(TreeNode n, int target, List<List<Integer>> result, List<Integer> current) {
        if (n == null)
            return;

        current.add(n.val);
        if (target == n.val) {
            result.add(new ArrayList<>(current));
        }

        helper(n.left, target - n.val, result, current);
        helper(n.right, target - n.val, result, current);
        current.remove(current.size() - 1);
    }
}
