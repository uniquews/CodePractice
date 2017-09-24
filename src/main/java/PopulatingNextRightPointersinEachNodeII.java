import utils.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 6/21/17.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode nextStart = null;

        while (cur != null) {
            TreeLinkNode prev = new TreeLinkNode(-1);
            while (cur != null) {
                if (cur.left != null) {
                    prev.next = cur.left;
                    if (nextStart == null) {
                        nextStart = cur.left;
                    }
                    prev = prev.next;
                }

                if (cur.right != null) {
                    prev.next = cur.right;
                    if (nextStart == null) {
                        nextStart = cur.right;
                    }
                    prev = prev.next;
                }
                cur = cur.next;
            }

            cur = nextStart;
            nextStart = null;
        }
    }

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
