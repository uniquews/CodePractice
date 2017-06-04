import utils.MultiTreeNode;

/**
 * Created by shuaiwang on 6/2/17.
 */
public class BinaryTreeLongestConsecutiveSequenceIII {
    class ReturnType {
        public int maxLen;
        public int maxUp;
        public int maxDown;

        public ReturnType(int l, int u, int d) {
            maxLen = l;
            maxUp = u;
            maxDown = d;
        }
    }

    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).maxLen;
    }

    private ReturnType helper(MultiTreeNode n) {
        if (n == null) {
            return new ReturnType(0, 0, 0);
        }

        int up = 0;
        int down = 0;
        int len = 1;
        for (MultiTreeNode m : n.children) {
            ReturnType r = helper(m);
            if (m != null && m.val == n.val + 1) {
                up = Math.max(up, r.maxUp + 1);
            }

            if (m != null && m.val == n.val - 1) {
                down = Math.max(down, r.maxDown + 1);
            }

            len = Math.max(r.maxLen, len);
        }

        len = Math.max(up + down + 1, len);
        ReturnType current = new ReturnType(len, up, down);
        return current;
    }
}
