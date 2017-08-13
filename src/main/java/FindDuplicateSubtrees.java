import utils.TreeNode;

import java.util.*;

/**
 * Created by shuaiwang on 8/12/17.
 */

/**
 *
 * 这道题可以用preorder和postorder做  但是不能用中序遍历做  会fail[0,0,0,0,null,null,0,null,null,null,0]
 * */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        helper(root, map, result);
        return result;
    }

    private String helper(TreeNode n, Map<String, List<TreeNode>> map, List<TreeNode> result) {
        if (n == null) {
            return "";
        }

        String leftNode = helper(n.left, map, result);
        String rightNode = helper(n.right, map, result);
        String current = String.valueOf(n.val);


        String key = leftNode + "#" + rightNode + "#" + current ;
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>(Arrays.asList(n)));
        } else if (map.get(key).size() == 1) {
            result.add(n);
            map.get(key).add(n);
        }
        return key;
    }
}
