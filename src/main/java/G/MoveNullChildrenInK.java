package G;

import utils.MultiTreeNode;

import java.util.List;

public class MoveNullChildrenInK {
    public void moveNullChildrenInK(MultiTreeNode root) {
        if (root == null) {
            return;
        }

        if (root.children.isEmpty()) {
            return;
        }

        int index = 0;
        for (int i = 0; i < root.children.size(); i++) {
            if (root.children.get(i) != null) {
                if (index != i) {
                    swap(root.children, i, index);
                }
                moveNullChildrenInK(root.children.get(index));
                index++;
            }
        }
    }

    private void swap(List<MultiTreeNode> list, int i, int j) {
        MultiTreeNode tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
