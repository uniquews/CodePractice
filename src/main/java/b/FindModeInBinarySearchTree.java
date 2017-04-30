package b;

import utils.TreeNode;

/**
 * Created by bohan on 4/29/17.
 */
public class FindModeInBinarySearchTree {
    private int maxOccur = 0;
    private int size = 0;
    private int count = 0;
    private int lastElement = 0; // 不知道初始化 int 该是什么
    private int index = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        maxOccur = 0;
        size = 0;
        count = 0;
        lastElement = root.val - 1;
        inorder(root);
        lastElement = root.val - 1;
        count = 0;
        int[] result = new int[size];
        inorder2(root, result);
        return result;
    }

    private void inorder(TreeNode n) {
        if (n == null) {
            return;
        }
        inorder(n.left);

        int val = n.val;
        if (val == lastElement) {
            count++;
        } else {
            count = 1;
        }
        if (count > maxOccur) {
            size = 1;
            maxOccur = count;
        } else if (count == maxOccur) {
            size++;
        }

        lastElement = val;
        inorder(n.right);
    }

    private void inorder2(TreeNode n, int[] result) {
        if (n == null) {
            return;
        }

        inorder2(n.left, result);
        int val = n.val;
        if (val == lastElement) {
            count++;
        } else {
            count = 1;
        }
        if (count == maxOccur) {
            result[index++] = val;
        }
        lastElement = val;
        inorder2(n.right, result);
    }
}
