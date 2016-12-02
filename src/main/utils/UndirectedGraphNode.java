package main.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 11/10/16.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
