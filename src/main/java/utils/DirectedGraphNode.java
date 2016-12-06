package utils;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 11/14/16.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    public int getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DirectedGraphNode && ((DirectedGraphNode) obj).getLabel() == this.label;
    }

    @Override
    public int hashCode() {
        return label / 333;
    }
}

