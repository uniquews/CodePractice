import utils.NestedInteger;

import java.util.List;

/**
 * Created by shuaiwang on 1/10/17.
 */


public class NestedListWeightSum {
    private int result = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        helper(nestedList, depth,0);
        return result;
    }

    private void helper(List<NestedInteger> nestedList, int depth, int index) {
        if (nestedList.get(index).isInteger()) {
            result += nestedList.get(index).getInteger() * depth;
            return;
        } else {
            List<NestedInteger> nextLevel = nestedList.get(index).getList();
            for (int i = 0; i < nextLevel.size(); i++) {
                helper(nestedList, depth + 1, i);
            }
        }
    }
}
