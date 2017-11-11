package fb;

import utils.TreeNode;

public class LeftViewOfBinaryTree {
    int maxLevel = -1;
    public void leftViewOfBinaryTree(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
            System.out.println(node.val);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
