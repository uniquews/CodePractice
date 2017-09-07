import utils.TreeLinkNode;

/**
 * Created by shuaiwang on 6/18/17.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode p = root;
        while (p != null) {
            TreeLinkNode prev = new TreeLinkNode(-1);
            TreeLinkNode nextP = p.left;
            while (p != null) {
                if (p.left != null) {
                    prev.next = p.left;
                    prev = prev.next;
                    prev.next = p.right;
                    prev = prev.next;
                }
                p = p.next;
            }
            p = nextP;
        }
    }
}
