import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 8/26/17.
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode n, Set<Integer> set, int target) {
        if (n == null) {
            return false;
        }

        if (set.contains(target - n.val)) {
            return true;
        }

        set.add(n.val);
        boolean leftNode = dfs(n.left, set, target);
        boolean rightNode = dfs(n.right, set, target);
        return leftNode || rightNode;
    }
}
