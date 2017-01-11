package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/10/17.
 */
public class NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return true;
    }
        // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 1;
    }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
       // Return null if this NestedInteger holds a single integer
   public List<NestedInteger> getList() {
        return new ArrayList<NestedInteger>();
   }
}
