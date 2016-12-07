import utils.ParentTreeNode;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class LowestCommonAncestorII {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here

        if (root == null) {
            return null;
        }

        ArrayList<ParentTreeNode> path1 = findRoot(root, A);
        ArrayList<ParentTreeNode> path2 = findRoot(root, B);

        int i = path1.size() - 1, j = path2.size() - 1;
        for (; i >= 0 || j >= 0; ) {

            if (i >= 0 && j >= 0) {
                if (path1.get(i) == path2.get(j)) {
                    i--;
                    j--;
                } else {
                    return path1.get(i).parent;
                }
            } else {
                if (i >= 0) {
                    return path1.get(i).parent;
                }

                if (j >= 0) {
                    return path2.get(j).parent;
                }
            }
        }

        return path1.get(i + 1);

    }

    private ArrayList<ParentTreeNode> findRoot(ParentTreeNode root, ParentTreeNode n) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();

        while (n != null) {
            path.add(n);
            n = n.parent;
        }

        return path;
    }
}
