import utils.NestedInteger;

import java.util.List;

/**
 * Created by shuaiwang on 1/10/17.
 */


public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        for (NestedInteger n : nestedList) {
            result += helper(n, 1);
        }
        return result;
    }

    private int helper(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return nestedList.getInteger() * depth;
        } else {
            int sum = 0;
            for (NestedInteger n : nestedInteger.getList()) {
                sum += helper(n, depth + 1);
            }
            return sum;
        }
    }
}
