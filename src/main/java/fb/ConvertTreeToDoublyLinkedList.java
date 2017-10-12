package fb;

import utils.TreeNode;
/*
* http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
* */
public class ConvertTreeToDoublyLinkedList {
    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        //由于要破坏树结构，所以要先处理左右孩子
        TreeNode leftNode = convert(root.left);
        TreeNode rightNode = convert(root.right);


        // 如果左右子树都为空，root和left和right应该分别指向自己
        root.left = root;
        root.right = root;

        TreeNode leftHalf = connect(leftNode, root);
        return connect(leftHalf, rightNode);
    }

    private TreeNode connect(TreeNode leftHead, TreeNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }

        if (rightHead == null) {
            return leftHead;
        }

        TreeNode leftTail = leftHead.left;
        TreeNode rightTail = rightHead.left;

        leftHead.left = rightTail;
        rightTail.right = leftHead;

        leftTail.right = rightHead;
        rightHead.left = leftTail;

        return leftHead;
    }

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;

        ConvertTreeToDoublyLinkedList test = new ConvertTreeToDoublyLinkedList();
        TreeNode result = test.convert(a);
        return;
    }

}
