package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/10/17.
 */
public class NestedInteger {
    private int value;
    private List<NestedInteger> list;
    private boolean isInteger = false;
    public NestedInteger() {}

    public NestedInteger(int value) {
        this.value = value;
        this.isInteger = true;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return this.isInteger;
    }
        // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return this.value;
    }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
       // Return null if this NestedInteger holds a single integer
   public List<NestedInteger> getList() {
        return this.list;
   }
}
