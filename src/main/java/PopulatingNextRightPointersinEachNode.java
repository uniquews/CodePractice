import utils.TreeLinkNode;

/**
 * Created by shuaiwang on 6/18/17.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode first = cur.left;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.next != null && cur.right != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            cur = first;
        }
    }
}
