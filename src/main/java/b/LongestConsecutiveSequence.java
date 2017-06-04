package b;

import java.util.List;

/**
 * Created by bohan on 6/2/17.
 */
public class LongestConsecutiveSequence {
    private class MultiTreeNode {
        int val;
        List<MultiTreeNode> children;

        MultiTreeNode(int val) {
            this.val = val;
        }
    }

    private class ResultType {
        int longest;
        int longestIncreasing;
        int longestDecreasing;

        ResultType(int longest, int longestIncreasing, int longestDecreasing) {
            this.longest = longest;
            this.longestIncreasing = longestIncreasing;
            this.longestDecreasing = longestDecreasing;
        }
    }

    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).longest;
    }

    private ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        int longest = 1;
        int longestIncreasing = 1;
        int longestDecreasing = 1;
        for (MultiTreeNode node : root.children) {
            ResultType result = helper(node);
            if (root.val - node.val == 1) {
                longestIncreasing = Math.max(longestIncreasing, result.longestIncreasing + 1);
            } else if (root.val - node.val == -1) {
                longestDecreasing = Math.max(longestDecreasing, result.longestDecreasing + 1);
            }
            longest = Math.max(result.longest, longest);
        }
        longest = Math.max(longest, longestIncreasing + longestDecreasing - 1);
        return new ResultType(longest, longestIncreasing, longestDecreasing);
    }
}
