import utils.TreeNode;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class DiameterOfBinaryTree {
    class ReturnType {
        public int leftLen;
        public int rightLen;
        public int maxLen;

        public ReturnType(int l, int r, int m) {
            leftLen = l;
            rightLen = r;
            maxLen = m;
        }

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root).maxLen - 1;
    }

    private ReturnType dfs(TreeNode n) {
        if (n == null) {
            return null;
        }

        ReturnType leftNode = dfs(n.left);
        ReturnType rightNode = dfs(n.right);

        int tmpLeft = 0;
        int tmpRight = 0;

        if (leftNode != null)
            tmpLeft = Math.max(leftNode.leftLen, leftNode.rightLen);
        if (rightNode != null)
            tmpRight = Math.max(rightNode.leftLen, rightNode.rightLen);
        ReturnType current = new ReturnType(0,0,0);
        current.leftLen = tmpLeft + 1;
        current.rightLen = tmpRight + 1;
        current.maxLen = Math.max(Math.max(leftNode == null ? 0 : leftNode.maxLen,
                rightNode == null ? 0 : rightNode.maxLen),
                tmpLeft + tmpRight + 1);
        return current;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        DiameterOfBinaryTree test = new DiameterOfBinaryTree();
        test.diameterOfBinaryTree(a);
    }
}
