import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public int houseRobber3(TreeNode root) {
        // write your code here
        Map<TreeNode, Map<Boolean, Integer>> cache = new HashMap<>();
        return dfs(root, false, cache);
    }

    private int dfs(TreeNode n, Boolean parent, Map<TreeNode, Map<Boolean, Integer>> cache) {
        if (n == null) {
            return 0;
        }


        if (cache.containsKey(n) && cache.get(n).containsKey(parent)) {
            return cache.get(n).get(parent);
        }

        int tmp = dfs(n.left, false, cache);
        tmp += dfs(n.right, false, cache);
        if (!parent) {
            int tmp2 = dfs(n.left, true, cache);
            tmp2 += dfs(n.right, true, cache);
            tmp = Math.max(tmp, tmp2 + n.val);
        }
        Map<Boolean, Integer> map = cache.getOrDefault(n, new HashMap<>());
        map.put(parent, tmp);
        cache.put(n, map);

        return tmp;
    }
}
