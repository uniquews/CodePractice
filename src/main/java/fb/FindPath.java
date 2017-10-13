package fb;

import utils.MultiTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindPath {
    public MultiTreeNode findPath(MultiTreeNode A, MultiTreeNode a, MultiTreeNode B) {
        if (A == null || a == null) {
            return null;
        }

        Queue<MultiTreeNode> q1 = new LinkedList<>();
        q1.add(A);

        Queue<MultiTreeNode> q2 = new LinkedList<>();
        q2.add(B);

        while (!q1.isEmpty()) {
            int size = q1.size();
            while (size > 0) {
                MultiTreeNode cur1 = q1.poll();
                MultiTreeNode cur2 = q2.poll();

                for (int i = 0; i < cur1.children.size(); i++) {
                    if (cur1.children.get(i) == a) {
                        return cur2.children.get(i);
                    }
                    q1.offer(cur1.children.get(i));
                    q2.offer(cur2.children.get(i));
                }
                size--;
            }
        }
        return null;
    }


}
