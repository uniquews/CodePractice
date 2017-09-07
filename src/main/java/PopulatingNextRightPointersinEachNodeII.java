import utils.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 6/21/17.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode p = root;

        while (p != null) {
            TreeLinkNode nextP = null;
            TreeLinkNode prev = new TreeLinkNode(-1);
            while (p != null) {
                if (p.left != null) {
                    if (nextP == null) {
                        nextP = p.left;
                    }
                    prev.next = p.left;
                    prev = prev.next;
                }

                if (p.right != null) {
                    if (nextP == null) {
                        nextP = p.right;
                    }
                    prev.next = p.right;
                    prev = prev.next;
                }
                p = p.next;
            }
            p = nextP;
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
