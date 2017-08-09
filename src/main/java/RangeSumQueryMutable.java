/**
 * Created by shuaiwang on 2/23/17.
 */
public class RangeSumQueryMutable {

//    class SegmentTreeNode {
//        public int start;
//        public int end;
//        public int sum;
//        private SegmentTreeNode left;
//        private SegmentTreeNode right;
//        public SegmentTreeNode(int s, int e) {
//            start = s;
//            end = e;
//            sum = 0;
//            left = null;
//            right = null;
//        }
//    }
//    private SegmentTreeNode root;
//
//    public RangeSumQueryMutable(int[] nums) {
//        root = buildTree(0, nums.length - 1, nums);
//    }
//
//    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
//        if (start > end) {
//            return null;
//        }
//
//        SegmentTreeNode node = new SegmentTreeNode(start, end);
//
//        if (start == end) {
//            node.sum = nums[start];
//            return node;
//        }
//
//        int mid = start + (end - start) / 2;
//        SegmentTreeNode leftTree = buildTree(start, mid, nums);
//        SegmentTreeNode rightTree = buildTree(mid + 1, end, nums);
//        node.sum = leftTree.sum + rightTree.sum;
//        node.left = leftTree;
//        node.right = rightTree;
//        return node;
//    }
//
//    public void update(int i, int val) {
//        updateDfs(root, i, val);
//    }
//
//    private SegmentTreeNode updateDfs(SegmentTreeNode node, int pos, int val) {
//        if (node.start == node.end) {
//            node.sum = val;
//            return node;
//        }
//
//        int mid = node.start + (node.end - node.start) / 2;
//        if (pos <= mid) {
//            updateDfs(node.left, pos, val);
//        } else if (pos >= mid + 1) {
//            updateDfs(node.right, pos, val);
//        }
//        node.sum = node.left.sum + node.right.sum;
//        return node;
//    }
//
//    public int sumRange(int i, int j) {
//        return sumRangeDfs(root, i, j);
//    }
//
//    private int sumRangeDfs(SegmentTreeNode node, int left, int right) {
//        if (node == null) {
//            return 0;
//        }
//        if (node.start == left && node.end == right) {
//            return node.sum;
//        }
//
//        int mid = node.start + (node.end - node.start) / 2;
//
//        if (left >= mid + 1) {
//            return sumRangeDfs(node.right, left, right);
//        } else if (right <= mid) {
//            return sumRangeDfs(node.left, left, right);
//        } else {
//            return sumRangeDfs(node.left, left, mid) +
//                    sumRangeDfs(node.right, mid + 1, right);
//        }
//    }

    // preSum 读的时间是O(1) update的时间是O(n)， 因为更新了一个nums[i] 比i大的index 都要更新
    // segment tree 是读的时间是O(logN)  update是基于这个树的高度的，所以也是O(logN)

    class SegmentTreeNode {
        public int start;
        public int end;
        public int sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public SegmentTreeNode() {

        }
    }

    class SegmentTree {
        public SegmentTreeNode root;
        public SegmentTree(int[] nums) {
            root = build(nums, 0, nums.length - 1);
        }

        private SegmentTreeNode build(int[] nums, int s, int e) {
            if (nums == null || nums.length == 0)
                return null;

            SegmentTreeNode n = new SegmentTreeNode();
            n.start = s;
            n.end = e;
            if (s == e) {
                n.sum = nums[s];
                return n;
            }

            int mid = s + (e - s) / 2;
            SegmentTreeNode leftNode = build(nums, s, mid);
            SegmentTreeNode rightNode = build(nums, mid + 1, e);
            n.left = leftNode;
            n.right = rightNode;
            n.sum = leftNode.sum + rightNode.sum;
            return n;
        }

        public void update(SegmentTreeNode n, int i, int val) {
            if (n.start == n.end && n.start == i) {
                n.sum = val;
                return;
            }

            int mid = n.start + (n.end - n.start) / 2;
            if (i <= mid) {
                update(n.left, i, val);
            } else {
                update(n.right, i, val);
            }
            n.sum = n.left.sum + n.right.sum;
        }

        public int sum(SegmentTreeNode n, int i, int j) {
            if (n.start == i && n.end == j) {
                return n.sum;
            }

            int mid = n.start + (n.end - n.start) / 2;
            if (j <= mid) {
                return sum(n.left, i, j);
            } else if (i >= mid + 1) {
                return sum(n.right, i, j);
            } else {
                return sum(n.left, i, mid) + sum(n.right, mid + 1, j);
            }
        }
    }

    SegmentTree st;
    public RangeSumQueryMutable(int[] nums) {
        st = new SegmentTree(nums);
    }

    public void update(int i, int val) {
        st.update(st.root, i, val);
    }

    public int sumRange(int i, int j) {
        return st.sum(st.root, i, j);
    }

    public static void main(String[] args) {
        int[] a = {0,9,5,7,3};
        RangeSumQueryMutable test = new RangeSumQueryMutable(a);
        System.out.print(test.sumRange(0, 4));
//        test.update(1, 2);
//        test.sumRange(0, 2);
    }
}
