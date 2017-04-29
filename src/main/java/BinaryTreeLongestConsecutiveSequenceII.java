import com.sun.org.apache.bcel.internal.generic.RETURN;
import utils.TreeNode;

/**
 * Created by shuaiwang on 4/28/17.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    private int maxCount;
    class ReturnType {
        public int leftSmallCount;
        public int leftLargeCount;
        public int rightSmallCount;
        public int rightLargeCount;

        public ReturnType() {

        }

        public ReturnType(int a, int b, int c, int d) {
            leftSmallCount = a;
            leftLargeCount = b;
            rightSmallCount = c;
            rightLargeCount = d;
        }
    }
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxCount;
    }

    private ReturnType helper(TreeNode n) {
        if (n == null) {
            return null;
        }

        ReturnType leftNode = helper(n.left);
        ReturnType rightNode = helper(n.right);
        ReturnType current = new ReturnType();

        int currentLeftSmallCount = 0;
        int currentLeftLargeCount = 0;
        int currentRightSmallCount = 0;
        int currentRightLargeCount = 0;

        if (n.left != null && n.left.val + 1 == n.val) {
            currentLeftSmallCount = Math.max(leftNode.leftSmallCount, leftNode.rightSmallCount) + 1;
        }

        if (n.left != null && n.left.val - 1 == n.val) {
            currentLeftLargeCount = Math.max(leftNode.leftLargeCount, leftNode.rightLargeCount) + 1;
        }

        if (n.right != null && n.right.val + 1 == n.val) {
            currentRightSmallCount = Math.max(rightNode.leftSmallCount, rightNode.rightSmallCount) + 1;
        }

        if (n.right != null && n.right.val - 1 == n.val) {
            currentRightLargeCount = Math.max(rightNode.leftLargeCount, rightNode.rightLargeCount) + 1;
        }

        maxCount = Math.max(maxCount, Math.max(currentLeftSmallCount + currentRightLargeCount,
                currentLeftLargeCount + currentRightSmallCount) + 1);

        return new ReturnType(currentLeftSmallCount, currentLeftLargeCount, currentRightSmallCount, currentRightLargeCount);
    }
}
