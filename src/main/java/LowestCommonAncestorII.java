import utils.ParentTreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class LowestCommonAncestorII {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        Set<ParentTreeNode> setA = new HashSet<>();
        Set<ParentTreeNode> setB = new HashSet<>();

        while (A != null || B != null) {
            if (A != null) {
                setA.add(A);
                if (setB.contains(A))
                    return A;
                A = A.parent;
            }

            if (B != null) {
                setB.add(B);
                if (setA.contains(B))
                    return B;
                B = B.parent;
            }
        }
        return null;
    }
}
