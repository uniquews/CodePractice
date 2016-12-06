package utils;

/**
 * Created by shuaiwang on 7/26/16.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
