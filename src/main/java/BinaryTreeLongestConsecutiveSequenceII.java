import com.sun.org.apache.bcel.internal.generic.RETURN;
import utils.TreeNode;

/**
 * Created by shuaiwang on 4/28/17.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
//    private int maxCount;
//    class ReturnType {
//        public int leftSmallCount;
//        public int leftLargeCount;
//        public int rightSmallCount;
//        public int rightLargeCount;
//
//        public ReturnType() {
//
//        }
//
//        public ReturnType(int a, int b, int c, int d) {
//            leftSmallCount = a;
//            leftLargeCount = b;
//            rightSmallCount = c;
//            rightLargeCount = d;
//        }
//    }
//    public int longestConsecutive(TreeNode root) {
//        helper(root);
//        return maxCount;
//    }
//
//    private ReturnType helper(TreeNode n) {
//        if (n == null) {
//            return null;
//        }
//
//        ReturnType leftNode = helper(n.left);
//        ReturnType rightNode = helper(n.right);
//        ReturnType current = new ReturnType();
//
//        int currentLeftSmallCount = 0;
//        int currentLeftLargeCount = 0;
//        int currentRightSmallCount = 0;
//        int currentRightLargeCount = 0;
//
//        if (n.left != null && n.left.val + 1 == n.val) {
//            currentLeftSmallCount = Math.max(leftNode.leftSmallCount, leftNode.rightSmallCount) + 1;
//        }
//
//        if (n.left != null && n.left.val - 1 == n.val) {
//            currentLeftLargeCount = Math.max(leftNode.leftLargeCount, leftNode.rightLargeCount) + 1;
//        }
//
//        if (n.right != null && n.right.val + 1 == n.val) {
//            currentRightSmallCount = Math.max(rightNode.leftSmallCount, rightNode.rightSmallCount) + 1;
//        }
//
//        if (n.right != null && n.right.val - 1 == n.val) {
//            currentRightLargeCount = Math.max(rightNode.leftLargeCount, rightNode.rightLargeCount) + 1;
//        }
//
//        maxCount = Math.max(maxCount, Math.max(currentLeftSmallCount + currentRightLargeCount,
//                currentLeftLargeCount + currentRightSmallCount) + 1);
//
//        return new ReturnType(currentLeftSmallCount, currentLeftLargeCount, currentRightSmallCount, currentRightLargeCount);
//    }

//    class ReturnType {
//        public int maxLength;
//        public int maxUp;
//        public int maxDown;
//
//        public ReturnType(int l, int u, int d) {
//            maxLength = l;
//            maxUp = u;
//            maxDown = d;
//        }
//    }
//    public int longestConsecutive2(TreeNode root) {
//        // Write your code here
//        return helper(root).maxLength;
//    }
//
//    private ReturnType helper(TreeNode n) {
//        if (n == null) {
//            return new ReturnType(0, 0, 0);
//        }
//
//        ReturnType leftNode = helper(n.left);
//        ReturnType rightNode = helper(n.right);
//
//        int down = 0;
//        int up = 0;
//        if (n.left != null && n.left.val == n.val + 1) {
//            up = leftNode.maxUp + 1;
//        }
//
//        if (n.right != null && n.right.val == n.val + 1) {
//            up = Math.max(up, rightNode.maxUp + 1);
//        }
//
//        if (n.left != null && n.left.val == n.val - 1) {
//            down = leftNode.maxDown + 1;
//        }
//
//        if (n.right != null && n.right.val == n.val - 1) {
//            down = Math.max(down, rightNode.maxDown + 1);
//        }
//
//        int len = down + up + 1;
//        int mLen = Math.max(len, Math.max(leftNode.maxLength, rightNode.maxLength));
//        return new ReturnType(mLen, up, down);
//    }


    class ReturnType {
        public int increase;
        public int decrease;
        public ReturnType(int i, int d) {
            increase = i;
            decrease = d;
        }
    }

    public int result;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return result;
    }

    private ReturnType helper(TreeNode n) {
        if (n == null) {
            return new ReturnType(0, 0);
        }

        ReturnType leftNode = helper(n.left);
        ReturnType rightNode = helper(n.right);

        int increase = 0, decrease = 0;

        if (n.left != null && n.val == n.left.val + 1) {
            increase = leftNode.increase;
        }

        if (n.right != null && n.val == n.right.val + 1) {
            increase = Math.max(increase, rightNode.increase);
        }

        if (n.left != null && n.val == n.left.val - 1) {
            decrease = leftNode.decrease;
        }

        if (n.right != null && n.val == n.right.val - 1) {
            decrease = Math.max(decrease, rightNode.decrease);
        }

        result = Math.max(result, increase + decrease + 1);
        return new ReturnType(increase + 1, decrease + 1);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;


        BinaryTreeLongestConsecutiveSequenceII test = new BinaryTreeLongestConsecutiveSequenceII();
        test.longestConsecutive(a);
    }
}
