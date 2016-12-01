package main.utils;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by shuaiwang on 11/14/16.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    public int getLabel() {return label;}


    @Override
    public boolean equals(Objects obj) {
        if ((obj instanceof  DirectedGraphNode) && ((DirectedGraphNode) obj).getLabel() == this.label) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (label / 333);
        return result;
    }
}
