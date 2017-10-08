import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        count = 0;
        if (root == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, sum, 0, map);
        return count;
    }

    private void helper(TreeNode n, int target, int preSum, Map<Integer, Integer> map) {
        if (n == null) {
            return;
        }

        preSum += n.val;
        if (map.containsKey(preSum - target)) {
            count += map.get(preSum - target);
        }

        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        helper(n.left, target, preSum, map);
        helper(n.right, target, preSum, map);

        map.put(preSum, map.get(preSum) - 1);
        // if (map.get(preSum) == 0) {
        //     map.remove(preSum);
        // }
    }
}
