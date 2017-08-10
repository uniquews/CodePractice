import com.sun.org.apache.regexp.internal.RE;
import utils.TreeNode;

/**
 * Created by shuaiwang on 3/30/17.
 */
public class KthSmallestElementInABST {
//    class ReturnType {
//        public int size;
//        public Integer resultNodeVal;
//
//        public ReturnType() {
//            resultNodeVal = null;
//        }
//        public ReturnType(int n) {
//            size = n;
//        }
//    }
//    public int kthSmallest(TreeNode root, int k) {
//        return helper(root, k).resultNodeVal;
//    }
//
//    private ReturnType helper(TreeNode current, int k) {
//        if (current == null) {
//            return new ReturnType(0);
//        }
//
//        ReturnType result = new ReturnType();
//        ReturnType leftNode = helper(current.left, k);
//        if (leftNode.resultNodeVal != null) {
//            result.resultNodeVal = leftNode.resultNodeVal;
//        }
//        if (leftNode.size == k - 1) {
//            result.resultNodeVal = current.val;
//        }
//        ReturnType rightNode = helper(current.right, k - leftNode.size - 1);
//        if (rightNode.resultNodeVal != null) {
//            result.resultNodeVal = rightNode.resultNodeVal;
//        }
//        result.size = leftNode.size + rightNode.size + 1;
//        return result;
//    }


    // 方法二
//    private int count;
//    private int result;
//    public int kthSmallest(TreeNode root, int k) {
//        count = k;
//        inorder(root);
//        return result;
//    }
//
//    private void inorder(TreeNode n) {
//        if (n == null)
//            return;
//        inorder(n.left);
//        count--;
//        if (count == 0) {
//            result = n.val;
//            return;
//        }
//        inorder(n.right);
//    }

    private int result;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private int helper(TreeNode n, int k) {
        if (n == null) {
            return 0;
        }

        int leftLen = helper(n.left, k);
        if (leftLen == k - 1) {
            result = n.val;
        }

        int rightLen = helper(n.right, k - 1 - leftLen);
        return leftLen + rightLen + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.right = b;
        KthSmallestElementInABST test = new KthSmallestElementInABST();
        test.kthSmallest(a, 2);
    }
}
