package utils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 6/2/17.
 */
public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> children;

    public MultiTreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "MultiTreeNode{" +
                "val=" + val +
                '}';
    }
}
