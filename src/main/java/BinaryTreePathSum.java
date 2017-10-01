import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> eachResult = new ArrayList<>();
        dfs(root, target, eachResult, result);
        return result;
    }

    private void dfs(TreeNode n, int target, List<Integer> eachResult, List<List<Integer>> result) {
        if (n == null) {
            return;
        }

        eachResult.add(n.val);
        if (n.left == null && n.right == null) {
            if (n.val == target) {
                result.add(new ArrayList<>(eachResult));
            }
            eachResult.remove(eachResult.size() - 1); // 什么时候 remove ？
            return;
        }

        dfs(n.left, target - n.val, eachResult, result);
        dfs(n.right, target - n.val, eachResult, result);
        eachResult.remove(eachResult.size() - 1);
        return;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);

        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;

        BinaryTreePathSum test = new BinaryTreePathSum();
        test.binaryTreePathSum(a, 5);

    }
}
