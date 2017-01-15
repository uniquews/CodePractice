import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Created by shuaiwang on 1/14/17.
 */

/**
 *
 * Key point: Calculate the height of the treeNode bottom-up. Nodes with same height
 * will be moving into one arrayList.
 *
 * Don't use the top-down level because the nodes are in the array may not have same
 * top-down level
 *
 * */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        getHeight(result, root);
        return result;
    }

    private int getHeight(List<List<Integer>> result, TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(result, node.left);
        int rightHeight = getHeight(result, node.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        if (result.size() == height) {
            result.add(new ArrayList());
        }
        result.get(height).add(node.val);
        return height;
    }
}

