import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 6/3/17.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        if (start == end) {
            TreeNode n = new TreeNode(start);
            result.add(n);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNode = helper(start, i - 1);
            List<TreeNode> rightNode = helper(i + 1 , end);

            for (TreeNode l : leftNode) {
                for (TreeNode r : rightNode) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
        test.generateTrees(3);
    }
}
