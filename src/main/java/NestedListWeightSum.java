import utils.NestedInteger;

import java.util.List;

/**
 * Created by shuaiwang on 1/10/17.
 */


public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int level) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                result += nestedList.get(i).getInteger() * level;
            } else {
                result += dfs(nestedList.get(i).getList(), level + 1);
            }
        }
        return result;
    }
}
