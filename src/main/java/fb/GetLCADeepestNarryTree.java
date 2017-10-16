package fb;

import utils.MultiTreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetLCADeepestNarryTree {
    class ReturnType {
        MultiTreeNode lca;
        int h;
        public ReturnType (MultiTreeNode lca, int h) {
            this.lca = lca;
            this.h = h;
        }

    }
    public MultiTreeNode getLca(MultiTreeNode root) {
        return helper(root).lca;
    }

    private ReturnType helper(MultiTreeNode n) {
        if (n == null) {
            return new ReturnType(null, 0);
        }

        List<ReturnType> list = new ArrayList<>();
        for (MultiTreeNode child : n.children) {
            list.add(helper(child));
        }

        int maxHeight = 0;
        int count = 0;
        MultiTreeNode deepestChild = null;
        for (ReturnType r : list) {
            if (r.h > maxHeight) {
                maxHeight = r.h;
                count = 1;
                deepestChild = r.lca;
            } else if (r.h == maxHeight) {
                count++;
            }
        }

        if (maxHeight == 0) {
            return new ReturnType(null, 1);
        }

        if (maxHeight == 1 && count >= 1) {
            return new ReturnType(n, 2);
        }

        if (maxHeight > 1 && count == 1) {
            return new ReturnType(deepestChild, maxHeight + 1);
        }

        // maxHeight > 1 && count > 1
        return new ReturnType(n, maxHeight + 1);
    }

    public static void main(String[] args) {
        MultiTreeNode a = new MultiTreeNode(1);
        MultiTreeNode b = new MultiTreeNode(2);
        MultiTreeNode c = new MultiTreeNode(3);
        MultiTreeNode d = new MultiTreeNode(4);
        MultiTreeNode e = new MultiTreeNode(5);

        MultiTreeNode f = new MultiTreeNode(6);
        MultiTreeNode g = new MultiTreeNode(7);
        MultiTreeNode h = new MultiTreeNode(8);
        MultiTreeNode i = new MultiTreeNode(9);
        MultiTreeNode j = new MultiTreeNode(10);


        a.children.add(b);
        a.children.add(c);
        b.children.add(d);
        d.children.add(e);

        b.children.add(f);
        f.children.add(g);
        b.children.add(h);
        h.children.add(i);
        i.children.add(j);


        GetLCADeepestNarryTree test = new GetLCADeepestNarryTree();
        System.out.println(test.getLca(a).val);
    }
}
