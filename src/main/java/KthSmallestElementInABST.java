import com.sun.org.apache.regexp.internal.RE;
import utils.TreeNode;

/**
 * Created by shuaiwang on 3/30/17.
 */
public class KthSmallestElementInABST {
    class ReturnType {
        public int numOfSmallerChildren;
        public boolean isKthSmallest;
        public int resultNodeVal;

        public ReturnType() {

        }
        public ReturnType(int n, boolean i) {
            numOfSmallerChildren = n;
            isKthSmallest = i;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).resultNodeVal;
    }

    private ReturnType helper(TreeNode current, int k) {
        if (current == null) {
            return new ReturnType(-1, false);
        }
        ReturnType result = new ReturnType();
        ReturnType leftNode = helper(current.left, k);
        ReturnType rightNode = helper(current.right, k - leftNode.numOfSmallerChildren - 1);

        if (leftNode.numOfSmallerChildren + rightNode.numOfSmallerChildren + 2 == k - 1) {
            result.numOfSmallerChildren = k - 1;
            result.isKthSmallest = true;
            result.resultNodeVal = current.val;
        } else {
            result.numOfSmallerChildren = leftNode.numOfSmallerChildren + rightNode.numOfSmallerChildren + 2;
            result.isKthSmallest = leftNode.isKthSmallest || rightNode.isKthSmallest;
            if (leftNode.isKthSmallest) {
                result.resultNodeVal = leftNode.resultNodeVal;
            }

            if (rightNode.isKthSmallest) {
                result.resultNodeVal = rightNode.resultNodeVal;
            }
        }
        return result;
    }
}
