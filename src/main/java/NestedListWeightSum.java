import utils.NestedInteger;

import java.util.List;

/**
 * Created by shuaiwang on 1/10/17.
 */


public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        int result = 0;
        for (int i = 0; i < nestedList.size(); i++)
            result += helper(nestedList, depth, i);
        return result;
    }

    private int helper(List<NestedInteger> nestedList, int depth, int index) {
        if (nestedList.get(index).isInteger()) {
            return nestedList.get(index).getInteger() * depth;
        } else {
            int sumOfList = 0;
            List<NestedInteger> nextLevel = nestedList.get(index).getList();
            for (int i = 0; i < nextLevel.size(); i++) {
                sumOfList += helper(nextLevel, depth + 1, i);
            }
            return sumOfList;
        }
    }
}
