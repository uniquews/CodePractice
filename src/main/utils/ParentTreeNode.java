package main.utils;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class ParentTreeNode {
    public int val;
    public ParentTreeNode left;
    public ParentTreeNode right;
    public ParentTreeNode parent;

    ParentTreeNode(int x)
    {
        this.val = x;
    }
}
