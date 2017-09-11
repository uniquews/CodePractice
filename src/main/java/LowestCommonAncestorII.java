import utils.ParentTreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class LowestCommonAncestorII {
//    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
//                                                 ParentTreeNode A,
//                                                 ParentTreeNode B) {
//        // Write your code here
//        Set<ParentTreeNode> setA = new HashSet<>();
//        Set<ParentTreeNode> setB = new HashSet<>();
//
//        while (A != null || B != null) {
//            if (A != null) {
//                setA.add(A);
//                if (setB.contains(A))
//                    return A;
//                A = A.parent;
//            }
//
//            if (B != null) {
//                setB.add(B);
//                if (setA.contains(B))
//                    return B;
//                B = B.parent;
//            }
//        }
//        return null;
//    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        int levelA = getLevel(A, root);
        int levelB = getLevel(B, root);

        while (A != B) {
            if (levelB > levelA) {
                B = B.parent;
                levelB--;
            } else if (levelA > levelB) {
                A = A.parent;
                levelA--;
            } else {
                A = A.parent;
                B = B.parent;
            }
        }
        return A;
    }

    private int getLevel(ParentTreeNode n, ParentTreeNode root) {
        ParentTreeNode current = n;
        int level = 0;
        while (current != root) {
            level++;
            current = current.parent;
        }
        return level;
    }

    public static void main(String[] args) {
        LowestCommonAncestorII test = new LowestCommonAncestorII();
        ParentTreeNode a = new ParentTreeNode(1);
        ParentTreeNode b = new ParentTreeNode(2);
        ParentTreeNode c = new ParentTreeNode(3);
        ParentTreeNode d = new ParentTreeNode(4);
        ParentTreeNode e = new ParentTreeNode(5);

        a.right = b;
        b.right = c;
        c.right = d;
        d.right = e;

        test.lowestCommonAncestorII(a, c, e);
    }
}
