/**
 * Created by shuaiwang on 2/23/17.
 */
public class RangeSumQueryMutable {

    class SegmentTreeNode {
        public int start;
        public int end;
        public int sum;
        private SegmentTreeNode left;
        private SegmentTreeNode right;
        public SegmentTreeNode(int s, int e) {
            start = s;
            end = e;
            sum = 0;
            left = null;
            right = null;
        }
    }
    private SegmentTreeNode root;

    public RangeSumQueryMutable(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }

    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start == end) {
            node.sum = nums[start];
            return node;
        }

        int mid = start + (end - start) / 2;
        SegmentTreeNode leftTree = buildTree(start, mid, nums);
        SegmentTreeNode rightTree = buildTree(mid + 1, end, nums);
        node.sum = leftTree.sum + rightTree.sum;
        node.left = leftTree;
        node.right = rightTree;
        return node;
    }

    public void update(int i, int val) {
        updateDfs(root, i, val);
    }

    private SegmentTreeNode updateDfs(SegmentTreeNode node, int pos, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return node;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (pos <= mid) {
            updateDfs(node.left, pos, val);
        } else if (pos >= mid + 1) {
            updateDfs(node.right, pos, val);
        }
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public int sumRange(int i, int j) {
        return sumRangeDfs(root, i, j);
    }

    private int sumRangeDfs(SegmentTreeNode node, int left, int right) {
        if (node == null) {
            return 0;
        }
        if (node.start == left && node.end == right) {
            return node.sum;
        }

        int mid = node.start + (node.end - node.start) / 2;

        if (left >= mid + 1) {
            return sumRangeDfs(node.right, left, right);
        } else if (right <= mid) {
            return sumRangeDfs(node.left, left, right);
        } else {
            return sumRangeDfs(node.left, left, mid) +
                    sumRangeDfs(node.right, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = {0,9,5,7,3};
        RangeSumQueryMutable test = new RangeSumQueryMutable(a);
        System.out.print(test.sumRange(4, 4));
//        test.update(1, 2);
//        test.sumRange(0, 2);
    }
}
