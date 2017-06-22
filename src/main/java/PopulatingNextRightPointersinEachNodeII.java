import utils.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 6/21/17.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode head = new TreeLinkNode(-1);
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = q.poll();
                if (node.left != null) {
                    head.next = node.left;
                    head = head.next;
                    q.offer(node.left);
                }

                if (node.right != null) {
                    head.next = node.right;
                    head = head.next;
                    q.offer(node.right);
                }
            }
        }
    }

// O(1) space
//    public void connect(TreeLinkNode root) {
//        if (root == null) {
//            return;
//        }
//
//        TreeLinkNode cur = root;
//        while (cur != null) {
//            TreeLinkNode nextLevel = null;
//            TreeLinkNode prev = new TreeLinkNode(-1);
//            while (cur != null) {
//                if (cur.left != null) {
//                    if (nextLevel == null)
//                        nextLevel = cur.left;
//                    prev.next = cur.left;
//                    prev = prev.next;
//                }
//                if (cur.right != null) {
//                    if (nextLevel == null)
//                        nextLevel = cur.right;
//                    prev.next = cur.right;
//                    prev = prev.next;
//                }
//                cur = cur.next;
//            }
//            cur = nextLevel;
//        }
//    }

    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        a.left = b;
        a.right = c;

        PopulatingNextRightPointersinEachNodeII test = new PopulatingNextRightPointersinEachNodeII();
        test.connect(a);
    }
}
